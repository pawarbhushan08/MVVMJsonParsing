package com.example.bhushan.mvvmjsonparsing.View;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bhushan.mvvmjsonparsing.R;
import com.example.bhushan.mvvmjsonparsing.ViewModel.PersonViewModel;
import com.example.bhushan.mvvmjsonparsing.databinding.ActivityMainBinding;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private ActivityMainBinding activityMainBinding;
    private PersonViewModel personViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupListPersonView(activityMainBinding.listPerson);
        setupObserver(personViewModel);
    }

    private void setupObserver(Observable observable) {
        observable.addObserver(this);
        /*personViewModel.initializeViews();
        personViewModel.pullPersonList();*/
    }

    private void setupListPersonView(RecyclerView listPerson) {
        PersonAdapter adapter = new PersonAdapter();
        listPerson.setAdapter(adapter);
        listPerson.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initDataBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        personViewModel = new PersonViewModel(this);
        activityMainBinding.setMainViewModel(personViewModel);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        personViewModel.reset();
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof PersonViewModel){
            PersonAdapter personAdapter = (PersonAdapter)activityMainBinding.listPerson.getAdapter();
            PersonViewModel personViewModel = (PersonViewModel) observable;
            personAdapter.setPersonList(personViewModel.getPersonList());
        }

    }
}

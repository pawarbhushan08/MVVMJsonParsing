package com.example.bhushan.mvvmplacemarkparsing.View;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.bhushan.mvvmplacemarkparsing.R;
import com.example.bhushan.mvvmplacemarkparsing.ViewModel.DataPlacemarkViewModel;
import com.example.bhushan.mvvmplacemarkparsing.ViewModel.PlacemarkViewModel;
import com.example.bhushan.mvvmplacemarkparsing.databinding.ActivityMainBinding;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private ActivityMainBinding activityMainBinding;
    private PlacemarkViewModel placemarkViewModel;
    Button btnShowOnMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupListPlacemarkView(activityMainBinding.listPlacemark);
        setupObserver(placemarkViewModel);
        btnShowOnMap = (Button) findViewById(R.id.btn_show_map);
        btnShowOnMap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(),
                        MapsActivity.class);
                i.putExtra("locations", DataPlacemarkViewModel.locations);
                /*i.putExtra("address", DataPlacemarkViewModel.Add);*/
                startActivity(i);
            }
        });


    }

    private void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    private void setupListPlacemarkView(RecyclerView listPlacemark) {
        PlacemarkAdapter adapter = new PlacemarkAdapter();
        listPlacemark.setAdapter(adapter);
        listPlacemark.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initDataBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        placemarkViewModel = new PlacemarkViewModel(this);
        activityMainBinding.setMainViewModel(placemarkViewModel);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        placemarkViewModel.reset();
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof PlacemarkViewModel){
            PlacemarkAdapter placemarkAdapter = (PlacemarkAdapter)activityMainBinding.listPlacemark.getAdapter();
            PlacemarkViewModel placemarkViewModel = (PlacemarkViewModel) observable;
            placemarkAdapter.setPlacemarkList(placemarkViewModel.getPlacemarks());
        }

    }



}

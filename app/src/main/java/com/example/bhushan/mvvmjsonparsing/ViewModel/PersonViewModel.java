package com.example.bhushan.mvvmjsonparsing.ViewModel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import com.example.bhushan.mvvmjsonparsing.Model.Person;
import com.example.bhushan.mvvmjsonparsing.PersonApplication;
import com.example.bhushan.mvvmjsonparsing.R;
import com.example.bhushan.mvvmjsonparsing.Services.PersonFactory;
import com.example.bhushan.mvvmjsonparsing.Services.PersonResponse;
import com.example.bhushan.mvvmjsonparsing.Services.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class PersonViewModel extends Observable{

    public ObservableInt personRecycler;

    private List<Person> personList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PersonViewModel(@NonNull Context context){
        this.context = context;
        this.personList = new ArrayList<>();
        personRecycler = new ObservableInt(View.GONE);
        initializeViews();
        pullPersonList();
    }

    public void initializeViews() {

        personRecycler.set(View.GONE);

    }

    public void pullPersonList() {

        PersonService personService = PersonFactory.create();

        Disposable disposable = personService.pullPerson(PersonFactory.PERSON_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<PersonResponse>() {
            @Override
            public void accept(PersonResponse personResponse) throws Exception {

                changePersonDataSet(personResponse.getPersonList());
                personRecycler.set(View.VISIBLE);
            }

        }, new Consumer<Throwable>(){

            @Override
            public void accept(Throwable throwable) throws Exception {

                personRecycler.set(View.GONE);

            }
        });
        compositeDisposable.add(disposable);
    }

    private void changePersonDataSet(List<Person> persons) {
        personList.addAll(persons);
        setChanged();
        notifyObservers();
    }

    public void reset() {
        if (compositeDisposable !=null && !compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
        compositeDisposable = null;
        context = null;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}


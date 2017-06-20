package com.example.bhushan.mvvmjsonparsing;

import android.app.Application;
import android.content.Context;

import com.example.bhushan.mvvmjsonparsing.Services.PersonFactory;
import com.example.bhushan.mvvmjsonparsing.Services.PersonService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class PersonApplication extends Application{

    private PersonService personService;
    private Scheduler scheduler;

    public static PersonApplication create(Context context) {
        return PersonApplication.get(context);
    }

    private static PersonApplication get(Context context) {
        return (PersonApplication) context.getApplicationContext();
    }


    public PersonService getPersonService() {
        if (personService == null){
            personService = PersonFactory.create();
        }

        return personService;
    }

    public void setPersonService(PersonService personService){
        this.personService = personService;
    }

    public Scheduler subscribeScheduler() {

        if (scheduler == null){
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setScheduler(Scheduler scheduler){
        this.scheduler = scheduler;
    }
}

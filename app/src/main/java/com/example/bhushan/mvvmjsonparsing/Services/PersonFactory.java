package com.example.bhushan.mvvmjsonparsing.Services;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Bhushan on 6/17/2017.
 */

public class PersonFactory {
    private final static String BASE_URL = "https://api.myjson.com";
    public final static String PERSON_URL = "https://api.myjson.com/bins/10pvr7";


    public static PersonService create() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        
        return retrofit.create(PersonService.class);
    }
}

package com.example.bhushan.mvvmplacemarkparsing.Services;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Bhushan on 6/17/2017.
 */

public class PlacemarkFactory {
    private final static String BASE_URL = "http://data.m-tribes.com";
    public final static String PERSON_URL = "http://data.m-tribes.com/locations.json";


    public static PlacemarkService create() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        
        return retrofit.create(PlacemarkService.class);
    }
}

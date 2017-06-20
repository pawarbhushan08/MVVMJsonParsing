package com.example.bhushan.mvvmjsonparsing.Services;

import android.databinding.ObservableInt;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Bhushan on 6/18/2017.
 */

public interface PersonService {

    @GET
    Observable<PersonResponse> pullPerson(@Url String url);
}

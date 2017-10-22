package com.example.bhushan.mvvmplacemarkparsing.Services;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Bhushan on 6/18/2017.
 */

public interface PlacemarkService {

    @GET
    Observable<PlacemarkResponse> pullPlacemark(@Url String url);
}

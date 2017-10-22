package com.example.bhushan.mvvmplacemarkparsing.Services;


import com.example.bhushan.mvvmplacemarkparsing.Model.Placemark;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class PlacemarkResponse {

    @SerializedName("placemarks") private List<Placemark> placemarks;

    public List<Placemark> getPlacemarks() {
        return placemarks;
    }
}

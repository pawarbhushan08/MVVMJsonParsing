package com.example.bhushan.mvvmplacemarkparsing.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class Placemark implements Serializable {
    @SerializedName("address")
    public String address;
    @SerializedName("engineType")
    public String engineType;
    @SerializedName("exterior")
    public String exterior;
    @SerializedName("interior")
    public String interior;
    @SerializedName("fuel")
    public int fuel;
    @SerializedName("name")
    public String name;
    @SerializedName("coordinates")
    public ArrayList<Double> coordinates;





}



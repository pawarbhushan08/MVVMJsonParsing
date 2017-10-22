package com.example.bhushan.mvvmplacemarkparsing.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.example.bhushan.mvvmplacemarkparsing.Model.Placemark;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class DataPlacemarkViewModel extends BaseObservable {


    Placemark placemarks;
    private Context context;




    public static ArrayList<LatLng> locations = new ArrayList<LatLng>();

    public ArrayList<LatLng> getLocations() {
        locations.add(new LatLng(placemarks.coordinates.get(1),placemarks.coordinates.get(0)));

        return locations;
    }


    public DataPlacemarkViewModel(Placemark placemarks, Context context){
        this.placemarks = placemarks;
        this.context = context;



    }



    public String getAddress(){


        return "Address: "+ placemarks.address;
    }

    public String getEngineType(){
        return "Engine Type: "+ placemarks.engineType;
    }

    public String getExterior(){
        return "Exterior: "+placemarks.exterior;
    }

    public String getInterior(){
        return "Interior: "+placemarks.interior;
    }

    public int getFuel(){
        return placemarks.fuel;
    }

    public String getName(){
        return "Name: "+placemarks.name;
    }


    public void setPlacemark(Placemark placemarks){
        this.placemarks = placemarks;
        notifyChange();
        getLocations();
    }


}

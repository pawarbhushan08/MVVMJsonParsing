package com.example.bhushan.mvvmplacemarkparsing;

import android.app.Application;
import android.content.Context;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class PlacemarkApplication extends Application{


    public static PlacemarkApplication create(Context context) {
        return PlacemarkApplication.get(context);
    }

    private static PlacemarkApplication get(Context context) {
        return (PlacemarkApplication) context.getApplicationContext();
    }


}

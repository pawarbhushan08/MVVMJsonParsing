package com.example.bhushan.mvvmjsonparsing.Model;

import android.graphics.Picture;
import android.media.*;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class Person implements Serializable{
    @SerializedName("id") public String id;
    @SerializedName("firstname")public String firstname;
    @SerializedName("lastname") public String lastname;
    @SerializedName("image") public String image;
}

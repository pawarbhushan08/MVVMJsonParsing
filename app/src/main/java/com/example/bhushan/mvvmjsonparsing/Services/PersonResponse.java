package com.example.bhushan.mvvmjsonparsing.Services;

import com.example.bhushan.mvvmjsonparsing.Model.Person;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class PersonResponse {

    @SerializedName("persons") private List<Person> personList;

    public List<Person> getPersonList(){
        return personList;
    }

}

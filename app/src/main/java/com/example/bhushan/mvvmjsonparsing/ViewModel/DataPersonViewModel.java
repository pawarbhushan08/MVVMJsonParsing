package com.example.bhushan.mvvmjsonparsing.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.media.Image;
import android.os.IBinder;
import android.widget.ImageView;

import com.example.bhushan.mvvmjsonparsing.Model.Person;
import com.example.bhushan.mvvmjsonparsing.R;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class DataPersonViewModel extends BaseObservable {
    private static ImageView imageView;
    private static String url;
    private Person persons;
    private Context context;

    public DataPersonViewModel(Person persons, Context context){
        this.persons = persons;
        this.context = context;
    }

    public String getId(){
        return persons.id;
    }

    public String getFirstname(){
        return persons.firstname;
    }

    public String getLastname(){
        return persons.lastname;
    }



    public String getImage(){
        return persons.image;
    }

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView imageView,String url){
        DataPersonViewModel.imageView = imageView;
        DataPersonViewModel.url = url;
        Picasso.with(imageView.getContext()).load(url).into(imageView);

    }

    public void setPerson(Person persons){
        this.persons = persons;
        notifyChange();
    }


}

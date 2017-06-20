package com.example.bhushan.mvvmjsonparsing.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.media.Image;
import android.os.IBinder;
import android.widget.ImageView;

import com.example.bhushan.mvvmjsonparsing.Model.Person;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class DataPersonViewModel extends BaseObservable {
    private Person person;
    private Context context;

    public DataPersonViewModel(Person person, Context context){
        this.person = person;
        this.context = context;
    }

    public String getId(){
        return person.id;
    }

    public String getFirstname(){
        return person.firstname;
    }

    public String getLastname(){
        return person.lastname;
    }

    public String getImage(){
        return person.image;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView,String url){
        Picasso.with(imageView.getContext()).load(url).resize(80,80).into(imageView);

    }

    public void setPerson(Person person){
        this.person = person;
        notifyChange();
    }


}

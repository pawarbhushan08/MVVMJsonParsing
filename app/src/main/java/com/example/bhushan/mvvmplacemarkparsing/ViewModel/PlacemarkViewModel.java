package com.example.bhushan.mvvmplacemarkparsing.ViewModel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.bhushan.mvvmplacemarkparsing.Model.Placemark;
import com.example.bhushan.mvvmplacemarkparsing.Services.PlacemarkFactory;
import com.example.bhushan.mvvmplacemarkparsing.Services.PlacemarkResponse;
import com.example.bhushan.mvvmplacemarkparsing.Services.PlacemarkService;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Bhushan on 6/17/2017.
 */

public class PlacemarkViewModel extends Observable{

    public ObservableInt placemarkRecycler;

    private List<Placemark> placemarkList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public PlacemarkViewModel(@NonNull Context context){
        this.context = context;
        this.placemarkList = new ArrayList<>();
        placemarkRecycler = new ObservableInt(View.GONE);

        initializeViews();
        pullPlacemarks();
    }

    public void initializeViews() {

        placemarkRecycler.set(View.GONE);

    }

    public void pullPlacemarks() {

        PlacemarkService placemarkService = PlacemarkFactory.create();

        Disposable disposable = placemarkService.pullPlacemark(PlacemarkFactory.PERSON_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<PlacemarkResponse>() {
            @Override
            public void accept(PlacemarkResponse placemarkResponse) throws Exception {

                changePlacemarkDataSet(placemarkResponse.getPlacemarks());
                placemarkRecycler.set(View.VISIBLE);
            }

        }, new Consumer<Throwable>(){

            @Override
            public void accept(Throwable throwable) throws Exception {

                placemarkRecycler.set(View.GONE);

            }
        });
        compositeDisposable.add(disposable);
    }

    private void changePlacemarkDataSet(List<Placemark> placemarks) {
        placemarkList.addAll(placemarks);
        setChanged();
        notifyObservers();
    }

    public void reset() {
        if (compositeDisposable !=null && !compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
        compositeDisposable = null;
        context = null;
    }

    public List<Placemark> getPlacemarks() {
        return placemarkList;
    }


}


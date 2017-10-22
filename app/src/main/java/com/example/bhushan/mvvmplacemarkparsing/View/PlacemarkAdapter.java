package com.example.bhushan.mvvmplacemarkparsing.View;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.bhushan.mvvmplacemarkparsing.Model.Placemark;
import com.example.bhushan.mvvmplacemarkparsing.R;
import com.example.bhushan.mvvmplacemarkparsing.ViewModel.DataPlacemarkViewModel;
import com.example.bhushan.mvvmplacemarkparsing.databinding.ItemPlacemarkBinding;

import java.util.Collections;
import java.util.List;

/**
 * Created by Bhushan on 6/18/2017.
 */

public class PlacemarkAdapter extends RecyclerView.Adapter<PlacemarkAdapter.PlacemarkAdapterViewHolder> {

    private List<Placemark> placemarkList;
    public PlacemarkAdapter(){
        this.placemarkList = Collections.emptyList();
    }
    @Override
    public PlacemarkAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemPlacemarkBinding itemPlacemarkBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_placemark,parent,false);

        return new PlacemarkAdapterViewHolder(itemPlacemarkBinding);
    }

    @Override
    public void onBindViewHolder(PlacemarkAdapterViewHolder holder, int position) {
        holder.bindPlacemark(placemarkList.get(position));
    }

   

    @Override
    public int getItemCount() {
        return placemarkList.size();
    }

    public void setPlacemarkList(List<Placemark> placemarkList) {
        this.placemarkList = placemarkList;
        notifyDataSetChanged();
    }

    public static class PlacemarkAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemPlacemarkBinding mItemPlacemarkBinding;

        public PlacemarkAdapterViewHolder(ItemPlacemarkBinding itemPlacemarkBinding) {
            super(itemPlacemarkBinding.itemPlacemark);
            this.mItemPlacemarkBinding = itemPlacemarkBinding;
        }

        void bindPlacemark(Placemark placemarks) {
            if (mItemPlacemarkBinding.getPlacemarkViewModel() == null){
                mItemPlacemarkBinding.setPlacemarkViewModel(new DataPlacemarkViewModel(placemarks,itemView.getContext()));
            }
            else {
                mItemPlacemarkBinding.getPlacemarkViewModel().setPlacemark(placemarks);
            }
        }
    }

}

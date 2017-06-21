package com.example.bhushan.mvvmjsonparsing.View;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.bhushan.mvvmjsonparsing.Model.Person;
import com.example.bhushan.mvvmjsonparsing.R;
import com.example.bhushan.mvvmjsonparsing.ViewModel.DataPersonViewModel;
import com.example.bhushan.mvvmjsonparsing.databinding.ItemPersonBinding;

import java.util.Collections;
import java.util.List;

/**
 * Created by Bhushan on 6/18/2017.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonAdapterViewHolder> {

    private List<Person> personList;
    public PersonAdapter(){
        this.personList = Collections.emptyList();
    }
    @Override
    public PersonAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemPersonBinding itemPersonBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_person,parent,false);

        return new PersonAdapterViewHolder(itemPersonBinding);
    }

    @Override
    public void onBindViewHolder(PersonAdapterViewHolder holder, int position) {
        holder.bindPerson(personList.get(position));

    }


    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    public static class PersonAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemPersonBinding mItemPersonBinding;

        public PersonAdapterViewHolder(ItemPersonBinding itemPersonBinding) {
            super(itemPersonBinding.itemPerson);
            this.mItemPersonBinding = itemPersonBinding;
        }

        void bindPerson(Person persons) {
            if (mItemPersonBinding.getPersonViewModel() == null){
                mItemPersonBinding.setPersonViewModel(new DataPersonViewModel(persons,itemView.getContext()));
            }
            else {
                mItemPersonBinding.getPersonViewModel().setPerson(persons);
            }
        }
    }
}

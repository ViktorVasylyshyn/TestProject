package com.crazyraccoonsteam.testproject.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazyraccoonsteam.testproject.R;
import com.crazyraccoonsteam.testproject.databinding.PersonItemBinding;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> dummy;
    private LayoutInflater layoutInflater;

    public PersonAdapter(List<Person> dummy){
        this.dummy = dummy;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        PersonItemBinding binding = PersonItemBinding.inflate(layoutInflater, viewGroup, false);
        return new PersonViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personHolder, int position) {
        personHolder.binding.setPerson(dummy.get(position));
    }

    @Override
    public int getItemCount(){
        return dummy.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder{

        private PersonItemBinding binding;

        private PersonViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }
    }
}

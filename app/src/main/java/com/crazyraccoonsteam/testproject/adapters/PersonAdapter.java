package com.crazyraccoonsteam.testproject.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazyraccoonsteam.testproject.databinding.PersonItemBinding;
import com.crazyraccoonsteam.testproject.pojo.Person;

import java.util.List;


public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder>{
    private List<Person> dummy;

    public PersonAdapter (List<Person> dummy){
        this.dummy = dummy;
    }


    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        PersonItemBinding binding = PersonItemBinding.inflate(inflater, viewGroup, false);
        return new PersonViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder personViewHolder, int i) {
        personViewHolder.binding.setPerson(dummy.get(i));

    }

    @Override
    public int getItemCount() {
        return dummy.size();
    }



    public static class PersonViewHolder extends RecyclerView.ViewHolder{

        PersonItemBinding binding;

        public PersonViewHolder(View view){
            super(view);
            binding = DataBindingUtil.bind(view);
        }
    }
}

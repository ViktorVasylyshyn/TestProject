package com.crazyraccoonsteam.testproject.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.crazyraccoonsteam.testproject.databinding.PersonItemBinding;
import com.crazyraccoonsteam.testproject.pojo.Person;

import java.util.List;

import javax.inject.Inject;


public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private List<Person> dummy;

    @Inject
    PersonAdapter(){
    }

    public void setData(List<Person> dummy) {
        this.dummy = dummy;
    }

    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        PersonItemBinding binding = PersonItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new PersonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder personViewHolder, int i) {
        personViewHolder.bindData(dummy.get(i));

    }

    @Override
    public int getItemCount() {
        return dummy.size();
    }


    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        private PersonItemBinding binding;

        public PersonViewHolder(PersonItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindData(final Person person) {

            binding.setPerson(person);
        }

    }
}

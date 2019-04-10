package com.crazyraccoonsteam.testproject.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.crazyraccoonsteam.testproject.data.pojo.PictureOfTheDay;
import com.crazyraccoonsteam.testproject.databinding.PictureOfTheDayItemBinding;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class PODAdapter extends RecyclerView.Adapter<PODAdapter.PODViewHolder> {

    private List<PictureOfTheDay> pictureOfTheDaysList = Collections.emptyList();

    @Inject
    public PODAdapter() {
    }

    public void setData(List<PictureOfTheDay> pictureOfTheDaysList) {
        this.pictureOfTheDaysList = pictureOfTheDaysList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PODViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        PictureOfTheDayItemBinding binding = PictureOfTheDayItemBinding.inflate(
                LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new PODViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PODViewHolder viewHolder, int i) {
        viewHolder.bindData(pictureOfTheDaysList.get(i));
    }

    @Override
    public int getItemCount() {
        return pictureOfTheDaysList.size();
    }

    static class PODViewHolder extends RecyclerView.ViewHolder {

        private PictureOfTheDayItemBinding mBinding;

        PODViewHolder(PictureOfTheDayItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        void bindData(final PictureOfTheDay pictureOfTheDay) {
            mBinding.setPicture(pictureOfTheDay);
        }
    }
}

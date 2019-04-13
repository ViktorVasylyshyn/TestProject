package com.crazyraccoonsteam.testproject.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.crazyraccoonsteam.testproject.App;
import com.crazyraccoonsteam.testproject.R;
import com.crazyraccoonsteam.testproject.adapters.PODAdapter;
import com.crazyraccoonsteam.testproject.databinding.HomeFragmentBinding;
import com.crazyraccoonsteam.testproject.viewmodels.HomeFragmentViewModel;

import javax.inject.Inject;

public class HomeFragment extends Fragment {

    @Inject
    HomeFragmentViewModel.HomeFragmentViewModelFactory homeFragmentViewModelFactory;

    @Inject
    PODAdapter mPODAdapter;

    private HomeFragmentBinding mBinding;

    private HomeFragmentViewModel mViewModel;

    public final ObservableBoolean mShowProgress = new ObservableBoolean(false);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((App) requireActivity().getApplication()).getAppComponent().injectHomeFragment(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);
        mBinding.setLifecycleOwner(this);
        initRV();
        return mBinding.getRoot();
    }

    private void initRV() {
        RecyclerView recyclerView = mBinding.astronomyPictureRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mPODAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBinding.setHomeFragment(this);
        mBinding.setShowProgress(mShowProgress);
        mViewModel = ViewModelProviders.of(this, homeFragmentViewModelFactory).get(HomeFragmentViewModel.class);
        mViewModel.gerPictureOfTheDay().observe(getViewLifecycleOwner(), pictureOfTheDay -> {
            if (pictureOfTheDay != null) {
                mPODAdapter.setData(pictureOfTheDay);
            }
            mShowProgress.set(false);
        });
        fetchAstronomyPictureOfTheDay();
    }

    private void fetchAstronomyPictureOfTheDay() {
        mViewModel.fetchAstronomyPictureOfTheDay();
        mShowProgress.set(true);
    }

    @BindingAdapter("android:src")
    public static void loadImage(ImageView view, String url) {
        if (url != null) {
            Glide.with(view.getContext()).load(url)
                    .into(view);
        }
    }
}

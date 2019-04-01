package com.crazyraccoonsteam.testproject.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.crazyraccoonsteam.testproject.App;
import com.crazyraccoonsteam.testproject.R;
import com.crazyraccoonsteam.testproject.adapters.PODAdapter;
import com.crazyraccoonsteam.testproject.viewmodels.HomeFragmentViewModel;

import javax.inject.Inject;

public class HomeFragment extends Fragment {

    @Inject
    HomeFragmentViewModel.HomeFragmentViewModelFactory homeFragmentViewModelFactory;

    @Inject
    PODAdapter mPODAdapter;

    private HomeFragmentViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ((App) getActivity().getApplication()).getAppComponent().injectHomeFragment(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        mProgressBar = view.findViewById(R.id.progressBar);
        initRV(view);
        return view;
    }

    private void initRV(View view) {
        mRecyclerView = view.findViewById(R.id.personsRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mPODAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, homeFragmentViewModelFactory).get(HomeFragmentViewModel.class);
        mViewModel.gerPictureOfTheDay().observe(getViewLifecycleOwner(), pictureOfTheDay -> {
            if (pictureOfTheDay != null) {
                mPODAdapter.setData(pictureOfTheDay);
                showProgress(false);
            }
        });
        fetchAstronomyPictureOfTheDay();
    }

    private void fetchAstronomyPictureOfTheDay() {
        mViewModel.fetchAstronomyPictureOfTheDay();
        showProgress(true);
    }

    private void showProgress(boolean show) {
        mProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}

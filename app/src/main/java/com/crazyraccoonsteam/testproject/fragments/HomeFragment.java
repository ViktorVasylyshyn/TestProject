package com.crazyraccoonsteam.testproject.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazyraccoonsteam.testproject.adapters.HomeRVAdapter;
import com.crazyraccoonsteam.testproject.viewmodels.HomeFragmentViewModel;
import com.crazyraccoonsteam.testproject.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeFragmentViewModel mViewModel;

    private RecyclerView mHomeRV;
    private RecyclerView.LayoutManager mHomeRVLayoutManager;
    private RecyclerView.Adapter mHomeRVAdapter;

    private List<String> mDummy = new ArrayList<>();

    View view;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);

        getDummyList();

        initRV();

        return view;
    }

    private void initRV() {
        mHomeRV = view.findViewById(R.id.homeRecyclerView);
        mHomeRV.setHasFixedSize(false);
        mHomeRV.setNestedScrollingEnabled(false);
        mHomeRVLayoutManager = new LinearLayoutManager(getContext());
        mHomeRV.setLayoutManager(mHomeRVLayoutManager);
        mHomeRVAdapter = new HomeRVAdapter(mDummy);
        mHomeRV.setAdapter(mHomeRVAdapter);

    }



    private List<String> getDummyList() {
        HomeFragmentViewModel homeFragmentViewModel = new HomeFragmentViewModel();
        mDummy = homeFragmentViewModel.getDummy();
        return mDummy;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
        // TODO: Use the ViewModel
    }



}

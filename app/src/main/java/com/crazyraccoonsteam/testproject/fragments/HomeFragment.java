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

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeFragmentViewModel mViewModel;
    private RecyclerView mHomeRV;
    private HomeRVAdapter mHomeRVAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        initRV(view);
        return view;
    }

    private void initRV(View view) {
        mHomeRV = view.findViewById(R.id.homeRecyclerView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
        mHomeRV.setLayoutManager(new LinearLayoutManager(getContext()));
        mHomeRVAdapter = new HomeRVAdapter(mViewModel.getDummy());
        mHomeRV.setAdapter(mHomeRVAdapter);

    }


}

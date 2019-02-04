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

import com.crazyraccoonsteam.testproject.adapters.PersonAdapter;
import com.crazyraccoonsteam.testproject.viewmodels.HomeFragmentViewModel;
import com.crazyraccoonsteam.testproject.R;

public class HomeFragment extends Fragment {

    private HomeFragmentViewModel mViewModel;
    private RecyclerView mPersonsRecyclerView;
    private PersonAdapter mPersondAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        initRV(view);
        return view;
    }

    private void initRV(View view) {
        mPersonsRecyclerView = view.findViewById(R.id.personsRecyclerView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
        mPersonsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPersondAdapter = new PersonAdapter(mViewModel.getPersons());
        mPersonsRecyclerView.setAdapter(mPersondAdapter);

    }


}

package com.crazyraccoonsteam.testproject.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazyraccoonsteam.testproject.MainActivity;
import com.crazyraccoonsteam.testproject.R;
import com.crazyraccoonsteam.testproject.viewmodels.WelcomeFragmentViewModel;

public class WelcomeFragment extends Fragment {

    private WelcomeFragmentViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewDataBinding mViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false);
        mViewDataBinding.setLifecycleOwner(this);

        return inflater.inflate(R.layout.welcome_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(WelcomeFragmentViewModel.class);
        mViewModel.getNavigateToHomeFragmentLiveData().observe(this, value -> {
            if (value != null && value) {
                ((MainActivity) requireActivity()).setFragment(new HomeFragment());
            }
        });
    }
}

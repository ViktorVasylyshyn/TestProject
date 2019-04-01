package com.crazyraccoonsteam.testproject.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazyraccoonsteam.testproject.MainActivity;
import com.crazyraccoonsteam.testproject.R;
import com.crazyraccoonsteam.testproject.databinding.WelcomeFragmentBinding;
import com.crazyraccoonsteam.testproject.viewmodels.WelcomeFragmentViewModel;

public class WelcomeFragment extends Fragment {
    private WelcomeFragmentBinding mViewDataBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false);
        mViewDataBinding.setLifecycleOwner(this);
        return mViewDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        WelcomeFragmentViewModel mViewModel = ViewModelProviders.of(this).get(WelcomeFragmentViewModel.class);
        mViewDataBinding.setWelcomeFragmentViewModel(mViewModel);
        mViewModel.getNavigateToHomeFragmentLiveData().observe(this, value -> {
            if (value != null && value) {
                mViewModel.resetNavigationValue();
                ((MainActivity) requireActivity()).setFragment(R.id.homeFragment);
            }
        });
    }
}

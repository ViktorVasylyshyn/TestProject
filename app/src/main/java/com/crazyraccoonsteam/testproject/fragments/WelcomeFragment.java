package com.crazyraccoonsteam.testproject.fragments;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.crazyraccoonsteam.testproject.MainActivity;
import com.crazyraccoonsteam.testproject.R;
import com.crazyraccoonsteam.testproject.viewmodels.WelcomeFragmentViewModel;

public class WelcomeFragment extends Fragment {

    private WelcomeFragmentViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.welcome_fragment, container, false);

        WelcomeFragmentViewModel wfvm = new WelcomeFragmentViewModel();

        Button mToHomeFragment = view.findViewById(R.id.toHomeFragment);
        mToHomeFragment.setOnClickListener(view1 -> {

            /*it's not a very elegant solution. But we will change it later*/

                    wfvm.setNavigateToHomeFragment(true);

                }
        );

        LiveData<Boolean> liveData = wfvm.getNavigateToHomeFragment();

        liveData.observe(this, value -> {
            if(value != null && value){
                ((MainActivity) requireActivity()).setFragment(new HomeFragment());
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WelcomeFragmentViewModel.class);
    }
}

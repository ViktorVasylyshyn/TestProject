package com.crazyraccoonsteam.testproject.fragments;

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

        Button button = view.findViewById(R.id.toHomeFragment);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((MainActivity)requireActivity()).setFragment(new HomeFragment());
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

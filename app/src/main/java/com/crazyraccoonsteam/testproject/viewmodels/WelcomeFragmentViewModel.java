package com.crazyraccoonsteam.testproject.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class WelcomeFragmentViewModel extends ViewModel {

    private MutableLiveData<Boolean> navigateToHomeFragment = new MutableLiveData<>();

    public void performNavigateToHomeFragment() {
        navigateToHomeFragment.setValue(true);
    }

    public LiveData<Boolean> getNavigateToHomeFragmentLiveData() {
        return navigateToHomeFragment;
    }
}

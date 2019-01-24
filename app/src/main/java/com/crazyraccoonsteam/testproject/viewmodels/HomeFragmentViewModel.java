package com.crazyraccoonsteam.testproject.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.crazyraccoonsteam.testproject.R;

import java.util.Arrays;
import java.util.List;

public class HomeFragmentViewModel extends ViewModel {

    public List<String> getDummy() {
        return Arrays.asList("Jimmy", "Tommy", "Bobby");
    }
}

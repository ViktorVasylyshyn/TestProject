package com.crazyraccoonsteam.testproject.viewmodels;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentViewModel extends ViewModel {

    public List<String> getDummy() {
        List<String> dummy;
        dummy = new ArrayList<>();
        dummy.add(0, "Jimmy");
        dummy.add(1, "Tommy");
        dummy.add(2, "Bobby");

        return dummy;
    }
}

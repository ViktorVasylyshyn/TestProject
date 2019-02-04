package com.crazyraccoonsteam.testproject.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.crazyraccoonsteam.testproject.R;
import com.crazyraccoonsteam.testproject.adapters.Person;

import java.util.Arrays;
import java.util.List;

public class HomeFragmentViewModel extends ViewModel {

    public List<Person> getPersons() {
        return Arrays.asList(Person);
    }
}

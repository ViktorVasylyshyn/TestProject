package com.crazyraccoonsteam.testproject.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.crazyraccoonsteam.testproject.pojo.Person;

import java.util.Arrays;
import java.util.List;

public class HomeFragmentViewModel extends ViewModel {

    public List<Person> getPersons() {
        return Arrays.asList(new Person("Jimmy", "18"),
                new Person("Bobby", "19"),
                new Person("Tommy", "20"),
                new Person("Валэра", "38"));
    }
}

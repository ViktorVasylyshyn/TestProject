package com.crazyraccoonsteam.testproject.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.crazyraccoonsteam.testproject.data.pojo.PictureOfTheDay;
import com.crazyraccoonsteam.testproject.domain.FetchAstronomyPictureOfTheDayUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class HomeFragmentViewModel extends ViewModel {

    private FetchAstronomyPictureOfTheDayUseCase useCase;

    @Inject
    HomeFragmentViewModel(FetchAstronomyPictureOfTheDayUseCase useCase) {
        this.useCase = useCase;
    }

    private MutableLiveData<List<PictureOfTheDay>> pictureOfTheDayMutableLiveData = new MutableLiveData<>();

    private List<PictureOfTheDay> pictureOfTheDaysList = new ArrayList<>();

    public LiveData<List<PictureOfTheDay>> gerPictureOfTheDay() {
        useCase.fetchAstronomyPictureOfTheDay();
        return pictureOfTheDayMutableLiveData;
    }

    public static class HomeFragmentViewModelFactory implements ViewModelProvider.Factory {

        private FetchAstronomyPictureOfTheDayUseCase fetchAstronomyPictureOfTheDayUseCase;

        public HomeFragmentViewModelFactory(FetchAstronomyPictureOfTheDayUseCase fetchAstronomyPictureOfTheDayUseCase) {
            this.fetchAstronomyPictureOfTheDayUseCase = fetchAstronomyPictureOfTheDayUseCase;
        }

        @SuppressWarnings("unchecked")
        @NonNull
        @Override
        public HomeFragmentViewModel create(@NonNull Class modelClass) {
            return new HomeFragmentViewModel(fetchAstronomyPictureOfTheDayUseCase);
        }
    }

}

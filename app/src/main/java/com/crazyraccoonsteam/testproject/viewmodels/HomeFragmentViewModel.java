package com.crazyraccoonsteam.testproject.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.Log;

import com.crazyraccoonsteam.testproject.data.pojo.PictureOfTheDay;
import com.crazyraccoonsteam.testproject.data.retrofit.RestClient;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentViewModel extends ViewModel {

    private RestClient restClient;

    @Inject
    HomeFragmentViewModel(RestClient restClient) {
        this.restClient = restClient;
    }

    private MutableLiveData<List<PictureOfTheDay>> pictureOfTheDayMutableLiveData = new MutableLiveData<>();

    private List<PictureOfTheDay> pictureOfTheDaysList = new ArrayList<>();

    public LiveData<List<PictureOfTheDay>> gerPictureOfTheDay() {
        return pictureOfTheDayMutableLiveData;
    }

    public void fetchAstronomyPictureOfTheDay() {
        restClient.getAPODApi()
                .getPictureOfTheDay()
                .enqueue(new Callback<PictureOfTheDay>() {
                    @Override
                    public void onResponse(@NonNull Call<PictureOfTheDay> call,
                                           @NonNull Response<PictureOfTheDay> response) {
                        if (response.isSuccessful()) {
                            PictureOfTheDay pictureOfTheDay = response.body();

                            if (null != pictureOfTheDay) {
                                pictureOfTheDaysList.add(pictureOfTheDay);
                                pictureOfTheDayMutableLiveData.setValue(pictureOfTheDaysList);
                            } else {
                                Log.e("TAG", "pictureOfTheDay equals to null");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<PictureOfTheDay> call, Throwable t) {
                        Log.d("TAG", "Error occurred while getting request!");
                    }
                });
    }

    public static class HomeFragmentViewModelFactory implements ViewModelProvider.Factory {

        private RestClient restClient;

        public HomeFragmentViewModelFactory(RestClient restClient) {
            this.restClient = restClient;
        }

        @SuppressWarnings("unchecked")
        @NonNull
        @Override
        public HomeFragmentViewModel create(@NonNull Class modelClass) {
            return new HomeFragmentViewModel(restClient);
        }
    }

}

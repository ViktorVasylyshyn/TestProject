package com.crazyraccoonsteam.testproject.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.crazyraccoonsteam.testproject.data.RestClient;
import com.crazyraccoonsteam.testproject.pojo.PictureOfTheDay;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragmentViewModel extends ViewModel {

    private MutableLiveData<List<PictureOfTheDay>> pictureOfTheDayMutableLiveData = new MutableLiveData<>();

    private List<PictureOfTheDay> pictureOfTheDaysList = new ArrayList<>();


    public LiveData<List<PictureOfTheDay>> gerPictureOfTheDay() {
        return pictureOfTheDayMutableLiveData;
    }


    public void fetchAstronomyPictureOfTheDay() {
        RestClient.getInstance()
                .getAPODApi()
                .getPictureOfTheDay()
                .enqueue(new Callback<PictureOfTheDay>() {
                    @Override
                    public void onResponse(@NonNull Call<PictureOfTheDay> call, @NonNull Response<PictureOfTheDay> response) {
                        if (response.isSuccessful()) {
                            PictureOfTheDay pictureOfTheDay = response.body();

                            if (null != pictureOfTheDay) {
                                pictureOfTheDaysList.add(pictureOfTheDay);
                                pictureOfTheDayMutableLiveData.setValue(pictureOfTheDaysList);
                            } else {
                                Log.e("INFO", "pictureOfTheDay equals to null");
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<PictureOfTheDay> call, Throwable t) {
                        System.out.println("Error occurred while getting request!");
                    }
                });
    }
}

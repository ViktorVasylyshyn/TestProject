package com.crazyraccoonsteam.testproject.domain;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.crazyraccoonsteam.testproject.data.pojo.PictureOfTheDay;
import com.crazyraccoonsteam.testproject.data.retrofit.RestClient;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchAstronomyPictureOfTheDayUseCase {

    private RestClient restClient;

    private MutableLiveData mPictureOfTheDayLiveData = new MutableLiveData();

    @Inject
    FetchAstronomyPictureOfTheDayUseCase(RestClient restClient) {
        this.restClient = restClient;
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
                                    mPictureOfTheDayLiveData.postValue(pictureOfTheDay);
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

    public LiveData getPictureOfTheDay(){
        return mPictureOfTheDayLiveData;
    }

}

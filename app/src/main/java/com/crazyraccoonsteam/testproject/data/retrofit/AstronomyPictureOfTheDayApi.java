package com.crazyraccoonsteam.testproject.data.retrofit;

import com.crazyraccoonsteam.testproject.data.pojo.PictureOfTheDay;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AstronomyPictureOfTheDayApi {

    @GET("planetary/apod")
    Call<PictureOfTheDay> getPictureOfTheDay();
}

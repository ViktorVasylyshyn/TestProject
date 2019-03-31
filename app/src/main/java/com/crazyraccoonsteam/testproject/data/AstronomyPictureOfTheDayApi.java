package com.crazyraccoonsteam.testproject.data;

import com.crazyraccoonsteam.testproject.pojo.PictureOfTheDay;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AstronomyPictureOfTheDayApi {

    @GET("planetary/apod?api_key=zpITlVrP6efoL5Qxv8CmceRYe1mMI6rI4fadkKEm")
    Call<PictureOfTheDay> getPictureOfTheDay();
}

package com.crazyraccoonsteam.testproject.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static final String API_LINK = "https://api.nasa.gov/";

    private AstronomyPictureOfTheDayApi astronomyPictureOfTheDayApi;

    private static RestClient mInstance;

    public static RestClient getInstance() {
        if (mInstance == null) {
            mInstance = new RestClient();
        }
        return mInstance;
    }

    RestClient() {
        build();
    }

    private void build() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(API_LINK)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        astronomyPictureOfTheDayApi = mRetrofit.create(AstronomyPictureOfTheDayApi.class);
    }

    public AstronomyPictureOfTheDayApi getAPODApi() {
        return astronomyPictureOfTheDayApi;
    }


}

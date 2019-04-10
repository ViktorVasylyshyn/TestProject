package com.crazyraccoonsteam.testproject.data.retrofit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestClient {

    private static final String API_LINK = "https://api.nasa.gov/";

    private AstronomyPictureOfTheDayApi astronomyPictureOfTheDayApi;

    @Inject
    public RestClient() {
        build();
    }

    private void build() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(API_LINK)
                .client(instantiateClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        astronomyPictureOfTheDayApi = mRetrofit.create(AstronomyPictureOfTheDayApi.class);
    }

    public AstronomyPictureOfTheDayApi getAPODApi() {
        return astronomyPictureOfTheDayApi;
    }

    private OkHttpClient instantiateClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(new ApiKeyInterceptor());
        return okHttpClientBuilder.build();
    }


}

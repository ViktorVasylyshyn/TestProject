package com.crazyraccoonsteam.testproject.data.retrofit;

import android.support.annotation.NonNull;

import com.crazyraccoonsteam.testproject.data.vo.ApiKey;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiKeyInterceptor implements Interceptor {

    private static final String QUERY_PARAM_NAME = "api_key";

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        HttpUrl modifiedHttpUrl = originalHttpUrl.newBuilder()
                .addQueryParameter(QUERY_PARAM_NAME, ApiKey.ASTRONOMY_PICTURE_API_KEY)
                .build();

        Request.Builder rb = originalRequest.newBuilder().url(modifiedHttpUrl);
        return chain.proceed(rb.build());
    }
}

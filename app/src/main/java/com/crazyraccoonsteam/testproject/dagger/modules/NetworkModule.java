package com.crazyraccoonsteam.testproject.dagger.modules;

import com.crazyraccoonsteam.testproject.dagger.RuntimeScope;
import com.crazyraccoonsteam.testproject.data.retrofit.RestClient;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @RuntimeScope
    RestClient provideRestClient() {
        return new RestClient();
    }
}

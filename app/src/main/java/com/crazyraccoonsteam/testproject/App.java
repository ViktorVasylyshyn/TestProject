package com.crazyraccoonsteam.testproject;

import android.app.Application;

import com.crazyraccoonsteam.testproject.dagger.component.AppComponent;
import com.crazyraccoonsteam.testproject.dagger.component.DaggerAppComponent;
import com.crazyraccoonsteam.testproject.dagger.modules.NetworkModule;

public class App extends Application {

    private AppComponent mAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    private void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .networkModule(new NetworkModule())
                .build();
    }
}

package com.crazyraccoonsteam.testproject.dagger.component;

import com.crazyraccoonsteam.testproject.MainActivity;
import com.crazyraccoonsteam.testproject.dagger.modules.NetworkModule;
import com.crazyraccoonsteam.testproject.fragments.HomeFragment;

import dagger.Component;

@Component(modules = {NetworkModule.class})
public interface AppComponent {

    void injectMainActivity(MainActivity mainActivity);

    void injectHomeFragment(HomeFragment homeFragment);
}

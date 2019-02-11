package com.crazyraccoonsteam.testproject.component;

import com.crazyraccoonsteam.testproject.MainActivity;
import com.crazyraccoonsteam.testproject.fragments.HomeFragment;
import com.crazyraccoonsteam.testproject.fragments.WelcomeFragment;

import dagger.Component;

@Component()
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(HomeFragment homeFragment);
    void inject(WelcomeFragment welcomeFragment);
}

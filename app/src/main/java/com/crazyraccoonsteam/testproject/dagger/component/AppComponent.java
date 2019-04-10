package com.crazyraccoonsteam.testproject.dagger.component;

import com.crazyraccoonsteam.testproject.dagger.RuntimeScope;
import com.crazyraccoonsteam.testproject.dagger.modules.NetworkModule;
import com.crazyraccoonsteam.testproject.dagger.modules.ViewModelProviderModule;
import com.crazyraccoonsteam.testproject.fragments.HomeFragment;

import dagger.Component;

@RuntimeScope
@Component(modules = {NetworkModule.class,
        ViewModelProviderModule.class})
public interface AppComponent {

    void injectHomeFragment(HomeFragment homeFragment);
}

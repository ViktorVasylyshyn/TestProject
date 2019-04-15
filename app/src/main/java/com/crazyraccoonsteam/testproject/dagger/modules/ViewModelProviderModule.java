package com.crazyraccoonsteam.testproject.dagger.modules;

import com.crazyraccoonsteam.testproject.data.retrofit.RestClient;
import com.crazyraccoonsteam.testproject.viewmodels.HomeFragmentViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelProviderModule {

    @Provides
    HomeFragmentViewModel.HomeFragmentViewModelFactory provideViewModel(RestClient restClient){
        return new HomeFragmentViewModel.HomeFragmentViewModelFactory(restClient);
    }
}

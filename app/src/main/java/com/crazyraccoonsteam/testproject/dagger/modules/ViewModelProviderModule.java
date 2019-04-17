package com.crazyraccoonsteam.testproject.dagger.modules;

import com.crazyraccoonsteam.testproject.domain.FetchAstronomyPictureOfTheDayUseCase;
import com.crazyraccoonsteam.testproject.viewmodels.HomeFragmentViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelProviderModule {

    @Provides
    HomeFragmentViewModel.HomeFragmentViewModelFactory provideHomeViewModel(FetchAstronomyPictureOfTheDayUseCase useCase) {
        return new HomeFragmentViewModel.HomeFragmentViewModelFactory(useCase);
    }
}

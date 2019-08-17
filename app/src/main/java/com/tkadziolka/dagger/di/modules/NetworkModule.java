package com.tkadziolka.dagger.di.modules;

import com.tkadziolka.dagger.utils.NetworkHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    NetworkHelper provideNetworkHelper(NetworkHelper networkHelper) {
        return networkHelper;
    }

}

package com.tkadziolka.dagger.di.modules;

import com.tkadziolka.dagger.data.DataSource;
import com.tkadziolka.dagger.data.LocalDataSource;
import com.tkadziolka.dagger.data.RemoteDataSource;
import com.tkadziolka.dagger.di.SharedPrefsSubComponent;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

@Module(subcomponents = SharedPrefsSubComponent.class)
public class DataModule {

    @Provides @IntoSet
    DataSource provideLocalDataSource(LocalDataSource localDataSource) {
        return localDataSource;
    }

    @Provides @IntoSet
    DataSource provideRemoteDataSource(RemoteDataSource remoteDataSource) {
        return remoteDataSource;
    }
}

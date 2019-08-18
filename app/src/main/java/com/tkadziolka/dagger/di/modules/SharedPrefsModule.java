package com.tkadziolka.dagger.di.modules;

import com.tkadziolka.dagger.data.SharedPrefsUtil;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefsModule {

    @Provides
    SharedPrefsUtil provideSharedPrefsUtil(SharedPrefsUtil sharedPrefsUtil) {
        return sharedPrefsUtil;
    }
}

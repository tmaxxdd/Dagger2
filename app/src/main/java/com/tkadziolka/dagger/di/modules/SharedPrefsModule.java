package com.tkadziolka.dagger.di.modules;

import com.tkadziolka.dagger.data.SharedPrefsUtil;

import dagger.Module;

@Module
public class SharedPrefsModule {

    SharedPrefsUtil provideSharedPrefs(SharedPrefsUtil sharedPrefsUtil) {
        return sharedPrefsUtil;
    }
}

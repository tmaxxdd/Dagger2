package com.tkadziolka.dagger.di.modules;

import com.tkadziolka.dagger.utils.NetworkHelper;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BroadcastModule {

    @ContributesAndroidInjector
    abstract NetworkHelper networkHelper();
}

package com.tkadziolka.dagger.di.modules;

import com.tkadziolka.dagger.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract MainFragment fragment();

}

package com.tkadziolka.dagger.di;

import com.tkadziolka.dagger.MainActivity;
import com.tkadziolka.dagger.OtherActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector()
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector()
    abstract OtherActivity otherActivity();

}

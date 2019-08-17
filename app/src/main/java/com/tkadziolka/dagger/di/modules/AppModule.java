package com.tkadziolka.dagger.di.modules;

import android.app.Application;
import android.content.Context;

import com.tkadziolka.dagger.di.ForApplication;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppModule {

    @Binds
    @Singleton
    @ForApplication
    abstract Context provideAppContext(Application app);

}

package com.tkadziolka.dagger;

import android.content.BroadcastReceiver;

import com.tkadziolka.dagger.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.support.DaggerApplication;

public class MyApp extends DaggerApplication implements HasBroadcastReceiverInjector {

    @Inject
    DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiver;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().app(this).build();
    }

    @Override
    public AndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {
        return broadcastReceiver;
    }
}

package com.tkadziolka.dagger.di;

import com.tkadziolka.dagger.di.modules.SharedPrefsModule;

import dagger.Subcomponent;

@Subcomponent(modules = SharedPrefsModule.class)
public interface SharedPrefsSubComponent {

    @Subcomponent.Builder
    interface Builder {
        Builder someSubModule(SharedPrefsModule module);
        SharedPrefsSubComponent build();
    }
}

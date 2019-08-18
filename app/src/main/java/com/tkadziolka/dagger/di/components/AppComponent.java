package com.tkadziolka.dagger.di.components;

import android.app.Application;

import com.tkadziolka.dagger.MyApp;
import com.tkadziolka.dagger.di.ActivityBindingModule;
import com.tkadziolka.dagger.di.modules.AppModule;
import com.tkadziolka.dagger.di.modules.DataModule;
import com.tkadziolka.dagger.di.modules.FragmentModule;
import com.tkadziolka.dagger.di.modules.MessageModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        AppModule.class,
        FragmentModule.class,
        DataModule.class,
        MessageModule.class
})
public interface AppComponent extends AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder app(Application application);
        AppComponent build();

    }

}

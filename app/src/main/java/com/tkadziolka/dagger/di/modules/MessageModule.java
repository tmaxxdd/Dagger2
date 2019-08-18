package com.tkadziolka.dagger.di.modules;

import com.tkadziolka.dagger.message.DebugMessage;
import com.tkadziolka.dagger.message.MyMessage;
import com.tkadziolka.dagger.message.UserMessage;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MessageModule {

    @Binds
    @Singleton
    @Named("DEBUG")
    public abstract MyMessage bindDebugMessage(DebugMessage message);

    @Binds
    @Singleton
    @Named("PRODUCTION")
    public abstract MyMessage bindUserMessage(UserMessage message);
}

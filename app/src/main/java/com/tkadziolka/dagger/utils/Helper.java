package com.tkadziolka.dagger.utils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Helper {

    @Inject Helper() {}

    String getWork() {
        return "Building";
    }

}

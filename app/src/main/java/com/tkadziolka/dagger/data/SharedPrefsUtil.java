package com.tkadziolka.dagger.data;

import javax.inject.Inject;

public class SharedPrefsUtil {

    @Inject
    public SharedPrefsUtil() {}

    public String getSharedData() {
        return "A data from shared preferences";
    }
}

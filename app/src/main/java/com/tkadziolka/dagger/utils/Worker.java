package com.tkadziolka.dagger.utils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Worker {

    private Helper helper;

    @Inject
    Worker(Helper helper) {
     this.helper = helper;
    }

    public String getWork() {
        return helper.getWork();
    }

}

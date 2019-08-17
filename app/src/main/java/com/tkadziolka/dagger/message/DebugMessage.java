package com.tkadziolka.dagger.message;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DebugMessage implements MyMessage {

    @Inject
    DebugMessage() {}

    @Override
    public void showMessage(String message) {
        Log.d("DEBUG: ", message);
    }

}

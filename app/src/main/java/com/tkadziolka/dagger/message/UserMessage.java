package com.tkadziolka.dagger.message;

import android.content.Context;
import android.widget.Toast;

import com.tkadziolka.dagger.di.ForApplication;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserMessage implements MyMessage {

    private Context context;

    @Inject
    @ForApplication
    UserMessage(Context context) {
        this.context = context;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}

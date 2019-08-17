package com.tkadziolka.dagger.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.tkadziolka.dagger.message.UserMessage;

import javax.inject.Inject;

public class NetworkHelper extends BroadcastReceiver {

    @Inject
    NetworkHelper() {}

    @Inject
    UserMessage userMessage;

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo network = cm.getActiveNetworkInfo();

        if (network != null) {
            userMessage.showMessage("Internet connected");
            NetworkState.isConnected = network.isConnectedOrConnecting();
        } else {
            userMessage.showMessage("Internet disconnected");
            NetworkState.isConnected = false;
        }
    }

}

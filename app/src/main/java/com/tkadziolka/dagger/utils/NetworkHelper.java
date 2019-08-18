package com.tkadziolka.dagger.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

public class NetworkHelper {

    @Inject public NetworkHelper() { }

    public boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo network = cm.getActiveNetworkInfo();
        if (network != null) {
            return network.isConnectedOrConnecting();
        } else {
            return false;
        }
    }

}

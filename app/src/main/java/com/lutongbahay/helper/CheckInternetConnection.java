package com.lutongbahay.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */


public class CheckInternetConnection {
    private final Context context;

    public CheckInternetConnection(Context context) {
        this.context = context.getApplicationContext();
    }

    public boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null)
            return false;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}

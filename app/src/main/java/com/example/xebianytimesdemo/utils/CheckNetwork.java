package com.example.xebianytimesdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckNetwork {

    static Context context;

    /*
     * @return boolean return true if the application can access the internet
     */
    public static boolean isNetworkAvailable(Context context) {
        CheckNetwork.context = context;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            // connected to the mobile provider's data plan
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                return true;
            } else return activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
        } else {
            // not connected to the internet
            return false;
        }
    }
}

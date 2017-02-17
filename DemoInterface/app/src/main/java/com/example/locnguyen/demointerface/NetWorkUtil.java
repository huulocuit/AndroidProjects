package com.example.locnguyen.demointerface;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by loc.nguyen on 2/16/2017.
 */

public class NetWorkUtil {

    private static final int WIFI = 1;
    private static final int MOBILE = 0;
    private static final int NOT_CONNECTED = -1;


    public static int getTypeConnection(Context context) {
        int type = NOT_CONNECTED;
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();
        if (networkInfo != null) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                type = WIFI;
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                type = MOBILE;
            }
        }
        return type;
    }

    public static String getStatusOfConnection(Context context) {
        int conn = getTypeConnection(context);
        if (conn == WIFI) {
            return "Wifi is enabled";
        } else if (conn == MOBILE) {
            return "Mobile data is enabled";
        } else
            return "Your device is not enabled";

    }

}

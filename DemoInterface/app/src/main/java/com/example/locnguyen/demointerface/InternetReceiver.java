package com.example.locnguyen.demointerface;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by loc.nguyen on 2/16/2017.
 */

public class InternetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String status =  NetWorkUtil.getStatusOfConnection(context);
      Toast.makeText(context, status,Toast.LENGTH_SHORT).show();

    }
}

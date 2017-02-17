package com.example.locnguyen.eventbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by loc.nguyen on 2/16/2017.
 */

public class ChargeReceiver extends BroadcastReceiver {

    String eventPower;
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
//            Toast.makeText(context,"DISCONNECTED",Toast.LENGTH_SHORT).show();
            eventPower = "0";
        }else if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
//            Toast.makeText(context,"CONNECTED",Toast.LENGTH_SHORT).show();
            eventPower = "1";
        }
        EventBus.getDefault().postSticky(eventPower);

    }
}

package com.example.locnguyen.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;

public class MyIntentService extends IntentService {

    public static String ACTION_1 = "ACTION1";
    public MyIntentService() {
        super("MyIntentService");
    }
    @Override
      protected void onHandleIntent(Intent intent) {
        Intent intent1 = new Intent();
        intent1.setAction(ACTION_1);

        for (int i = 0; i <=100; i++) {
            intent1.putExtra("percent", i);
            sendBroadcast(intent1);
            SystemClock.sleep(100);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

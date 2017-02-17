package com.example.locnguyen.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlaySongService extends Service {

   public static MediaPlayer mediaPlayer;
    public PlaySongService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        //Service nay khong phai la loai rang buoc ne se tra ve null
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.testmp3);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }


}

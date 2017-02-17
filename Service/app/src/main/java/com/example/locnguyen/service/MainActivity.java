package com.example.locnguyen.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean firstopen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstopen = true;

    }

    public void playService(View view) {
        Intent intent = new Intent(this, PlaySongService.class);
        if (firstopen) {
            startService(intent);
            ((TextView) view).setText("Stop");
            firstopen = false;
        } else {
            if (PlaySongService.mediaPlayer.isPlaying()) {
                stopService(intent);
                ((TextView) view).setText("Play");
            } else {
                startService(intent);
                ((TextView) view).setText("Stop");
            }
        }

    }

    public void pauseService(View view) {
        PlaySongService.mediaPlayer.pause();
        ((TextView) findViewById(R.id.play)).setText("Play");
        firstopen = true;
    }
}

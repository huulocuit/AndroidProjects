package com.example.locnguyen.intentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startService;
    Button stopService;
    TextView text_percel;
    ProgressBar progressBar;

    BroadcastReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService = (Button)findViewById(R.id.button_start);
        stopService = (Button)findViewById(R.id.button_stop);
        text_percel = (TextView) findViewById(R.id.text_percel);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);


        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerReceiver(receiver,new IntentFilter(MyIntentService.ACTION_1));
                Intent intent = new Intent(MainActivity.this,MyIntentService.class);
                startService(intent);

            }
        });

        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStop();
            }
        });
    }

    class ShowProgressBarTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... args) {

            return args[0];
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);

            progressBar.setProgress(result);

            text_percel.setText(result + " % Loaded");

            if (result == 100) {
                text_percel.setText("Completed");

            }

        }
    }

    @Override
    protected void onStart() {
       receiver =  new BroadCastReceiver();
        super.onStart();
    }

    public class BroadCastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(MyIntentService.ACTION_1)){
               int i = intent.getIntExtra("percent",-1);
//               new ShowProgressBarTask().execute(i);
                progressBar.setProgress(i);
                if(i==100){
                    text_percel.setText("Completed");
                }else{
                    text_percel.setText(i+" %");
                }

            }
        }
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop();
    }
}

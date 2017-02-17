package com.example.locnguyen.demointerface;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String dataFromFragMent;
    ProgressDialog progressDialog;
    RadioButton rdOn;
    RadioButton rdOff;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TranferFragment tranferFragment =  new TranferFragment();
        fragmentTransaction.add(R.id.downloadFragment,tranferFragment,"tranferfragment");
        fragmentTransaction.commit();
        EventBus.getDefault().register(this);
        findViewById(R.id.download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog   = ProgressDialog.show(MainActivity.this, "Please wait...", "Loading data ...", true);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(dataFromFragMent!=null){
                            textView.setText(dataFromFragMent);
                        }else{
                            textView.setText("No Data to display");
                        }
                        progressDialog.dismiss();
                    }
                },3000);

            }
        });
        Intent intent = registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        boolean startPowerState = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1)>0;
        if(startPowerState){
            rdOn.setChecked(true);
        }else
            rdOff.setChecked(true);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventObject eventObject){
        dataFromFragMent = eventObject.getName()+" "+eventObject.getType();

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(boolean event){
       Toast.makeText(this,event+"",Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String status){
        if(status.equals("1")){
            rdOn.setChecked(true);
        }else
            rdOff.setChecked(true);

    }
    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
    private void initView(){

        rdOff = (RadioButton)findViewById(R.id.off);
        rdOn = (RadioButton)findViewById(R.id.on);
        textView=(TextView)findViewById(R.id.textview);
    }
}

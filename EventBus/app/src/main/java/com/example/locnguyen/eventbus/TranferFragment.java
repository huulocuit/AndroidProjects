package com.example.locnguyen.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by loc.nguyen on 2/16/2017.
 */

public class TranferFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_download,container,false);
        Button button = (Button) mview.findViewById(R.id.sendData);
        final EventObject eventObject =  new EventObject("Loc","Boy");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(eventObject);
                Toast.makeText(getActivity(),"Data sent",Toast.LENGTH_LONG).show();
            }
        });
        return mview;
    }





}

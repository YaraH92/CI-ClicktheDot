package com.yarahaddad.clickthedot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class CurrentTime extends Fragment {
    public View retView;
    public TextView text;
    DateFormat df;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        retView= inflater.inflate(R.layout.fragment_current_time, container, false);
         df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        text=retView.findViewById(R.id.textView11);

        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                try{
                    getActivity().runOnUiThread(new Runnable() {
                        @SuppressLint("NewApi")
                        @Override
                        public void run() {
                            Date currentTime = Calendar.getInstance().getTime();
                            text.setText(df.format(currentTime));
                        }
                    });
                }
                catch(NullPointerException e)
                {
                    System.out.print("NullPointerException Caught");
                }

            }
        }, 0,1000);
        return retView;
    }

}

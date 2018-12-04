package com.yarahaddad.clickthedot;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.WIFI_SERVICE;


public class WebServer extends Fragment {
    public View retView;
    public WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        retView = inflater.inflate(R.layout.fragment_web_server, container);
        webView=retView.findViewById(R.id.webView1);
        getWebServer();
        return retView;    }

    public void getWebServer() {

        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @SuppressLint("NewApi")
                    @Override
                    public void run() {
                        webView.loadUrl("http://192.168.2.100:8081/WebServer.jsp");
                    }
                });
            }
        }, 0,1000*60*60*24);
    }

}

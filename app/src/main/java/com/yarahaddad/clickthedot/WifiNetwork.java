package com.yarahaddad.clickthedot;

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
import android.widget.TextView;

import static android.content.Context.WIFI_SERVICE;


public class WifiNetwork extends Fragment {
    public View retView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        retView = inflater.inflate(R.layout.fragment_wifi_network, container);
        getWifiName();
        return retView;    }

    public void getWifiName() {
        String ssid = "No wifi Network";
        WifiManager wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        NetworkInfo.DetailedState state=WifiInfo.getDetailedStateOf(wifiInfo.getSupplicantState());
        if ((state == NetworkInfo.DetailedState.CONNECTED)||(state==NetworkInfo.DetailedState.OBTAINING_IPADDR)) {
            if(wifiInfo!=null)
            {
                ssid = "Wifi Netwrok: "+wifiInfo.getSSID();
            }
        }
        TextView text = retView.findViewById(R.id.textView20);
        text.setText(ssid);
    }

}

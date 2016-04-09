package com.calcserver.intz.calcserver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int state=intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1);
        String msg=null;

        switch (state) {
            case WifiManager.WIFI_STATE_DISABLED:
                msg="is disabled";
                break;

            case WifiManager.WIFI_STATE_DISABLING:
                msg="is disabling";
                break;

            case WifiManager.WIFI_STATE_ENABLED:
                msg="is enabled";
                break;

            case WifiManager.WIFI_STATE_ENABLING:
                msg="is enabling";
                break;

            case WifiManager.WIFI_STATE_UNKNOWN :
                msg="has an error";
                break;

            default:
                msg="is acting strangely";
                break;
        }

        if (msg!=null) {
            Log.d("OnWiFiChanged", "WiFi " + msg);
        }
    }
}

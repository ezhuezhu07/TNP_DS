package com.example.tnp_ds;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if(networkInfo!=null)
        {
            if(networkInfo.getType()==ConnectivityManager.TYPE_MOBILE)
            {
                Toast.makeText(context,"Internet By Mobile Data",Toast.LENGTH_LONG).show();
            }
            if(networkInfo.getType()==ConnectivityManager.TYPE_WIFI)
            {
                Toast.makeText(context,"Internet By Wifi data",Toast.LENGTH_LONG).show();
            }
            else
            {
                    Toast.makeText(context,"NO Internet",Toast.LENGTH_LONG).show();
            }
        }
    }
}

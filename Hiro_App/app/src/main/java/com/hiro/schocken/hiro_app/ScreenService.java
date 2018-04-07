package com.hiro.schocken.hiro_app;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class ScreenService extends Service {
    private BroadcastReceiver sReceiver;

    public IBinder onBind(Intent arg){
        return null;
    }

    public  int onStartCommand(Intent intent,int flag, int startIs){
        // Detect screen
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        sReceiver=new ScreenReceiver();
        registerReceiver(sReceiver,filter);
        return  START_STICKY;
    }

    public void onDestroy(){
        if(sReceiver!=null)
            unregisterReceiver(sReceiver);
        super.onDestroy();
    }
}

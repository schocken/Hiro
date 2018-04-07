package com.hiro.schocken.hiro_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent){
        if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            Log.i("Log", "The screen is on.");
        }
        else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            Log.i("Log", "The screen is off.");
        }
        else if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)){
            Log.i("Log","userpresent");
        }
    }

}


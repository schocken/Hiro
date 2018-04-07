package com.hiro.schocken.hiro_app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Intent screenningService;
    Intent sensoringService;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View mainView = inflater.inflate(R.layout.fragment_main, container, false);
        Button startButton = (Button) mainView.findViewById(R.id.startButton);
        screenningService = new Intent(this.getContext(), ScreenService.class);
        sensoringService = new Intent(this.getContext(), SensorService.class);
        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startScreenEvent(v);
            }
        });

        return mainView;
    }

    public void startScreenEvent(View v){

        if(v.getTag() == null){
            getActivity().startService(screenningService);
            getActivity().startService(sensoringService);
            v.setTag("on");
            ((Button)v).setText("Stop Service");
            Toast.makeText(this.getContext(), "Start Service", Toast.LENGTH_SHORT).show();
        }
        else{
            getActivity().stopService(screenningService);
            getActivity().stopService(sensoringService);
            v.setTag(null);
            ((Button)v).setText("Start Service");
            Toast.makeText(this.getContext(), "Stop Service", Toast.LENGTH_SHORT).show();
        }

    }
}

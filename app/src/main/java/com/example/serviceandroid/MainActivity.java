package com.example.serviceandroid;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View v)
    {
        if (isMyServiceRunning()) return;
        startService(new Intent(MainActivity.this, StopAppService.class));
    }

    public void stop(View v)
    {
        if (!isMyServiceRunning()) return;
        stopService(new Intent(MainActivity.this, StopAppService.class));
    }

    // проверка, запущен ли сервис
    private boolean isMyServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (StopAppService.class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
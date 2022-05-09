package com.example.serviceandroid;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StopAppService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressWarnings("ResourceType")
    public void onCreate() {
        // creating the instance of the WallpaperManager
         final WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
         GregorianCalendar gs = new GregorianCalendar();
         gs.getTime();
         GregorianCalendar gc = new GregorianCalendar();
         gc.add(Calendar.SECOND,30);
         gc.getTime();
        try {
            // set the wallpaper by calling the setResource function and
            // passing the drawable file
            wallpaperManager.setResource(R.drawable.img);
            if(gs.compareTo(gc)==0){
                wallpaperManager.setResource(R.drawable.img_1);
            }
        } catch (IOException e) {
            // here the errors can be logged instead of printStackTrace
            e.printStackTrace();
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Toast.makeText(this, "Сервис запущен!", Toast.LENGTH_SHORT).show();
        // https://stackoverflow.com/questions/33710694/start-sticky-not-working
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Сервис остановлен!", Toast.LENGTH_SHORT).show();
    }
}
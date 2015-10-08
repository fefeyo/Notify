package com.fefeyo.wakeupapp;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

/**
 * Created by USER on 2015/10/08.
 */
public class MySerice extends IntentService{

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MySerice(String name) {
        super(name);
    }

    public MySerice(){
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("onHandleIntent", "onHandleIntent");
        final Notification n = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("８秒たったよ")
                .setContentText("起き上がれAndroid")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build()
                ;
        NotificationManagerCompat.from(getApplicationContext()).notify(0, n);
    }
}

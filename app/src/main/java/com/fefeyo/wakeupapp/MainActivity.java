package com.fefeyo.wakeupapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notify(View v){
        final Intent i = new Intent(getApplicationContext(), MySerice.class);
        final PendingIntent pi = PendingIntent.getService(
                MainActivity.this,
                0,
                i,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.SECOND, 8);
        final AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        am.set(
                AlarmManager.RTC_WAKEUP,
                c.getTimeInMillis(),
                pi
        );
    }


}
package com.demo.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    private MyService.MyBinder myBinder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MyService.MyBinder) iBinder;
            Log.d("gxd", "MainActivity.onServiceConnected-->" + myBinder.getInfo());
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("gxd", "MainActivity.onServiceDisconnected-->");
            myBinder = null;
        }
    };

    public void bindService(View view) {
        if (myBinder == null) {
            Intent intent = new Intent(this, MyService.class);
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        } else {
            Log.d("gxd", "MainActivity.bindService-->" + myBinder.getInfo());
        }
    }

    public void unbindService(View view) {
        unbindService(serviceConnection);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    public void intentService(View view) {
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        if (myBinder != null) {
            unbindService(serviceConnection);
        }
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
        super.onDestroy();
    }
}

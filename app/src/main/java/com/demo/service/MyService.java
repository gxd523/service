package com.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("gxd", "MyService.onCreate-->");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("gxd", "MyService.onStartCommand-->");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("gxd", "MyService.onBind-->");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("gxd", "MyService.onUnbind-->");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("gxd", "MyService.onDestroy-->");
        super.onDestroy();
    }

    public static class MyBinder extends Binder {
        public String getInfo() {
            return "Service返回了binder";
        }
    }
}

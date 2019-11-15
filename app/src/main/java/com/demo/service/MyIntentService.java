package com.demo.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("gxd", "MyIntentService.onCreate-->");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d("gxd", "MyIntentService.onStartCommand-->");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("gxd", "MyIntentService.onHandleIntent-->开始耗时操作");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("gxd", "MyIntentService.onHandleIntent-->耗时操作完成");
    }

    @Override
    public void onDestroy() {
        Log.d("gxd", "MyIntentService.onDestroy-->");
        super.onDestroy();
    }
}

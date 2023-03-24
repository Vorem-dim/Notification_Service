package com.example.pizzaandsushi;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.IBinder;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class Services extends Service {
    private WindowManager windowManager;
    private View view;
    private TextView text;

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        view = LayoutInflater.from(this).inflate(R.layout.service, null);
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        text = view.findViewById(R.id.textView);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.CENTER;
        text.setText("Notification is send");
        windowManager.addView(view, params);

        text.setOnClickListener(view -> {
            Intent retur = new Intent(getApplicationContext(), MainActivity.class);
            retur.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(retur);
            stopSelf();
        });
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (view != null)
            windowManager.removeView(view);
    }
}
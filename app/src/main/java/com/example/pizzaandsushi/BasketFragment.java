package com.example.pizzaandsushi;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

public class BasketFragment extends Fragment {
    private static final int NOTIFICATION_ID = 101;
    private static final String CHANNEL_ID = "channel_id";

    public BasketFragment() {
        super(R.layout.fragment_basket);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.pizza_main_screen)
                        .setContentTitle("Title")
                        .setContentText("Notification")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFICATION_ID, builder.build());
            }
        });
    }
}
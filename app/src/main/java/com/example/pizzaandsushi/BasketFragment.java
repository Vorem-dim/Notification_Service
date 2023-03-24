package com.example.pizzaandsushi;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

public class BasketFragment extends Fragment {
    private static final int NOTIFICATION_ID = 101;
    private static final String CHANNEL_ID = "channel_id";
    private LinearLayout layout;
    private WindowManager windowManager = null;

    public BasketFragment() {
        super(R.layout.fragment_basket);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.pizza_main_screen)
                        .setContentTitle("Title")
                        .setContentText("Notification")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFICATION_ID, builder.build());
                Intent intent = new Intent(getActivity(), Services.class);
                getActivity().startService(intent);
            }
        });

        ImageButton button1 = view.findViewById(R.id.Menu_button);
        button1.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, MenuFragment.class, null).commit();
        });

        ImageButton button2 = view.findViewById(R.id.Profile_icon_button);
        button2.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, ProfileFragment.class, null).commit();
        });

        ImageButton button3 = view.findViewById(R.id.Basket_button);
        button3.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, BasketFragment.class, null).commit();
        });
    }
}
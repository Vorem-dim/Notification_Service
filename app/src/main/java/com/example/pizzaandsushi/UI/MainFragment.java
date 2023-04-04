package com.example.pizzaandsushi.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pizzaandsushi.R;

public class MainFragment extends Fragment {

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button_menu = view.findViewById(R.id.Menu);
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, MenuFragment.class, null).commit();
            }
        });

        Button button_profile = view.findViewById(R.id.Profile);
        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, RegistrationFragment.class, null).commit();
            }
        });

        Button button_basket = view.findViewById(R.id.Basket);
        button_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, BasketFragment.class, null).commit();
            }
        });
    }
}
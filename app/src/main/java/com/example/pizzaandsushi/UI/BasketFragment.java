package com.example.pizzaandsushi.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pizzaandsushi.R;

public class BasketFragment extends Fragment {

    public BasketFragment() {
        super(R.layout.fragment_basket);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
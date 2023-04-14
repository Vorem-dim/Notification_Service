package com.example.pizzaandsushi.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzaandsushi.Model.MenuField;
import com.example.pizzaandsushi.Model.PositionField;
import com.example.pizzaandsushi.R;
import com.example.pizzaandsushi.RecyclerMenu;
import com.example.pizzaandsushi.RecyclerPosition;
import com.example.pizzaandsushi.ViewModels.ViewPattern;

public class MenuFragment extends Fragment {
    private ViewPattern viewPattern;
    private RecyclerPosition adapter_position;

    public MenuFragment() {
        super(R.layout.fragment_menu);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPattern = new ViewModelProvider(this).get(ViewPattern.class);
        viewPattern.initViewPattern(getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView ListMenu = view.findViewById(R.id.RecyclerCuisine);
        RecyclerMenu.OnClickListener ListenerMenu = new RecyclerMenu.OnClickListener() {
            @Override
            public void OnClick(MenuField field, int position) {
                adapter_position.ChangeIndex(position);
                viewPattern.position.observe(getViewLifecycleOwner(), adapter_position::update);
            }
        };
        RecyclerMenu adapter_menu = new RecyclerMenu(getContext(), ListenerMenu);
        ListMenu.setAdapter(adapter_menu);
        viewPattern.menu.observe(getViewLifecycleOwner(), adapter_menu::update);

        RecyclerView ListPosition = view.findViewById(R.id.RecyclerMenu);
        RecyclerPosition.OnClickListener ListenerPosition = new RecyclerPosition.OnClickListener() {
            @Override
            public void OnClick(PositionField field, int position) {

            }
        };
        adapter_position = new RecyclerPosition(getContext(), ListenerPosition);
        ListPosition.setAdapter(adapter_position);
        viewPattern.position.observe(getViewLifecycleOwner(), adapter_position::update);

        ImageButton button1 = view.findViewById(R.id.Profile_icon_button);
        button1.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_MenuToProfile);
        });

        ImageButton button2 = view.findViewById(R.id.Basket_button);
        button2.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_MenuToBasket);
        });
    }
}
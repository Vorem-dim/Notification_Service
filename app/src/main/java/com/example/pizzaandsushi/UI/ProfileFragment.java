package com.example.pizzaandsushi.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.pizzaandsushi.R;

public class ProfileFragment extends Fragment {
    private String Name;
    private String Email;
    private String Surname;
    private String Telephone;

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getContext(), R.string.Enter_profile, Toast.LENGTH_LONG).show();
        Name = getArguments().getString("Name");
        Email = getArguments().getString("Email");
        Surname = getArguments().getString("Surname");
        Telephone = getArguments().getString("Telephone");
        TextView text = view.findViewById(R.id.NameProfile);
        text.setText(getString(R.string.Name) + ": " + Name);
        text = view.findViewById(R.id.SurnameProfile);
        text.setText(getString(R.string.Surname) + ": " + Surname);
        text = view.findViewById(R.id.EmailProfile);
        text.setText(getString(R.string.Email) + ": " + Email);
        text = view.findViewById(R.id.TelephoneProfile);
        text.setText(getString(R.string.Phone) + ": " + Telephone);

        ImageButton button1 = view.findViewById(R.id.Menu_button);
        button1.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_ProfileToMenu);
        });

        ImageButton button2 = view.findViewById(R.id.Profile_icon_button);
        button2.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_ProfileToRegistration);
        });

        ImageButton button3 = view.findViewById(R.id.Basket_button);
        button3.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_ProfileToBasket);
        });
    }
}
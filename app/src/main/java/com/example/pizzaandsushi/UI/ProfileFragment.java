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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ProfileFragment extends Fragment {
    String filename = "User";

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getContext(), R.string.Enter_profile, Toast.LENGTH_LONG).show();

        FileInputStream fis;
        String Data[];
        try {
            fis = getContext().openFileInput(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Data = stringBuilder.toString().split("\n");
        }
        ((TextView)view.findViewById(R.id.NameProfile)).setText(getString(R.string.Name) + ": " + Data[0]);
        ((TextView)view.findViewById(R.id.SurnameProfile)).setText(getString(R.string.Surname) + ": " + Data[1]);
        ((TextView)view.findViewById(R.id.EmailProfile)).setText(getString(R.string.Email) + ": " + Data[2]);
        ((TextView)view.findViewById(R.id.TelephoneProfile)).setText(getString(R.string.Phone) + ": " + Data[3]);

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
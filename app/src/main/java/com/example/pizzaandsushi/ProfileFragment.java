package com.example.pizzaandsushi;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

        getParentFragmentManager().setFragmentResultListener("ToProfile", this, (key, bundle) -> {
            Toast.makeText(getContext(), R.string.Enter_profile, Toast.LENGTH_LONG).show();

            Name = bundle.getString("Name");
            Email = bundle.getString("Email");
            Surname = bundle.getString("Surname");
            Telephone = bundle.getString("Telephone");

            TextView text = view.findViewById(R.id.NameProfile);
            text.setText(getString(R.string.Name) + ": " + Name);
            text = view.findViewById(R.id.SurnameProfile);
            text.setText(getString(R.string.Surname) + ": " + Surname);
            text = view.findViewById(R.id.EmailProfile);
            text.setText(getString(R.string.Email) + ": " + Email);
            text = view.findViewById(R.id.TelephoneProfile);
            text.setText(getString(R.string.Phone) + ": " + Telephone);
        });

        ImageButton button1 = view.findViewById(R.id.Menu_button);
        button1.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, MenuFragment.class, null).commit();
        });

        ImageButton button2 = view.findViewById(R.id.Profile_icon_button);
        button2.setOnClickListener(v -> {
            Bundle transfer = new Bundle();
            transfer.putString("Name", Name);
            transfer.putString("Email", Email);
            transfer.putString("Surname", Surname);
            transfer.putString("Telephone", Telephone);
            getParentFragmentManager().setFragmentResult("FromProfile", transfer);
            getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, RegistrationFragment.class, null).commit();
        });

        ImageButton button3 = view.findViewById(R.id.Basket_button);
        button3.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, BasketFragment.class, null).commit();
        });
    }
}
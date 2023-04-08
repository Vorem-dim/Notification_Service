package com.example.pizzaandsushi.UI;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pizzaandsushi.R;
import com.example.pizzaandsushi.UI.ProfileFragment;
import com.example.pizzaandsushi.ViewModels.StorageViewPattern;
import com.example.pizzaandsushi.ViewModels.ViewPattern;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegistrationFragment extends Fragment {
    private StorageViewPattern viewPattern;

    public RegistrationFragment() {
        super(R.layout.fragment_registration);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPattern = new ViewModelProvider(this).get(StorageViewPattern.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.Profile_button);
        button.setOnClickListener(v -> {
            String Name = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_name)).getEditText().getText());
            String Email = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_email)).getEditText().getText());
            String Surname = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_surname)).getEditText().getText());
            String Telephone = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_telephone)).getEditText().getText());

            viewPattern.CreateAppSpecific(requireContext(), "app_specific", Name + Email + Surname + Telephone);

            viewPattern.CreateExternal(requireContext(), "external", Name + Email + Surname + Telephone);

            viewPattern.CreateSharedPreferences(requireContext(), "shared_preference", Name + Email + Surname + Telephone);

            if (!Name.equals("") && !Email.equals("") && !Surname.equals("") && !Telephone.equals("")) {
                Navigation.findNavController(view).navigate(R.id.action_RegistrationToProfile);
            }
            else
                Toast.makeText(getContext(), R.string.Empty_fields, Toast.LENGTH_LONG).show();
        });
    }
}
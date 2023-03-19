package com.example.pizzaandsushi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegistrationFragment extends Fragment {

    public RegistrationFragment() {
        super(R.layout.fragment_registration);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("FromProfile", this, (key, bundle) -> {
            TextInputLayout text = view.findViewById(R.id.Profile_name);
            text.getEditText().setText(bundle.getString("Name"));
            text = view.findViewById(R.id.Profile_email);
            text.getEditText().setText(bundle.getString("Email"));
            text = view.findViewById(R.id.Profile_surname);
            text.getEditText().setText(bundle.getString("Surname"));
            text = view.findViewById(R.id.Profile_telephone);
            text.getEditText().setText(bundle.getString("Telephone"));
        });

        Button button = view.findViewById(R.id.Profile_button);
        button.setOnClickListener(v -> {
            String Name = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_name)).getEditText().getText());
            String Email = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_email)).getEditText().getText());
            String Surname = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_surname)).getEditText().getText());
            String Telephone = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_telephone)).getEditText().getText());
            if (!Name.equals("") && !Email.equals("") && !Surname.equals("") && !Telephone.equals("")) {
                Bundle transfer = new Bundle();
                transfer.putString("Name", Name);
                transfer.putString("Email", Email);
                transfer.putString("Surname", Surname);
                transfer.putString("Telephone", Telephone);
                getParentFragmentManager().setFragmentResult("ToProfile", transfer);
                getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, ProfileFragment.class, null).commit();
            }
            else {
                Toast.makeText(getContext(), R.string.Empty_fields, Toast.LENGTH_LONG).show();
                if (!Name.equals(""))
                    ((TextInputLayout)view.findViewById(R.id.Profile_name)).getEditText().setHintTextColor(getResources().getColor(R.color.red, getContext().getTheme()));
                if (Email.equals(""))
                    ((TextInputLayout)view.findViewById(R.id.Profile_email)).getEditText().setHintTextColor(getResources().getColor(R.color.red, getContext().getTheme()));
                if (Surname.equals(""))
                    ((TextInputLayout)view.findViewById(R.id.Profile_surname)).getEditText().setHintTextColor(getResources().getColor(R.color.red, getContext().getTheme()));
                if (Telephone.equals(""))
                    ((TextInputLayout)view.findViewById(R.id.Profile_telephone)).getEditText().setHintTextColor(getResources().getColor(R.color.red, getContext().getTheme()));
            }
        });
    }
}
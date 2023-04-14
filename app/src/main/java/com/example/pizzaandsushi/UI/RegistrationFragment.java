package com.example.pizzaandsushi.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.pizzaandsushi.DataSource.Room.DataBase;
import com.example.pizzaandsushi.DataSource.User;
import com.example.pizzaandsushi.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationFragment extends Fragment {
    private boolean update = false;
    private DataBase database;

    public RegistrationFragment() {
        super(R.layout.fragment_registration);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = DataBase.getInstance(getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            update = getArguments().getBoolean("update");
            ((TextInputLayout)view.findViewById(R.id.Profile_name)).getEditText().setText(getArguments().getString("Name"));
            ((TextInputLayout)view.findViewById(R.id.Profile_surname)).getEditText().setText(getArguments().getString("Surname"));
            ((TextInputLayout)view.findViewById(R.id.Profile_telephone)).getEditText().setText(getArguments().getString("Telephone"));
            ((TextInputLayout)view.findViewById(R.id.Profile_email)).getEditText().setText(getArguments().getString("Email"));
            ((Button)view.findViewById(R.id.Profile_button)).setText(R.string.Registration_button1);
        }

        Button button = view.findViewById(R.id.Profile_button);
        button.setOnClickListener(v -> {
            String Name = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_name)).getEditText().getText());
            String Email = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_email)).getEditText().getText());
            String Surname = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_surname)).getEditText().getText());
            String Telephone = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_telephone)).getEditText().getText());
            String Gender = "";
            if (((RadioButton)view.findViewById(R.id.Male)).isChecked())
                Gender = "Male";
            else if (((RadioButton)view.findViewById(R.id.Female)).isChecked())
                Gender = "Female";

            if (!Name.equals("") && !Email.equals("") && !Surname.equals("") && !Telephone.equals("")) {
                if (update) {
                    Toast.makeText(getContext(), R.string.Edit_profile, Toast.LENGTH_LONG).show();
                    database.userDao().updateUser(Name, Surname, Telephone, Email, Gender);
                }
                else {
                    Toast.makeText(getContext(), R.string.Enter_profile, Toast.LENGTH_LONG).show();
                    database.userDao().insertUser(new User(Name, Surname, Telephone, Email, Gender));
                }
                Navigation.findNavController(view).navigate(R.id.action_RegistrationToProfile);
            }
            else
                Toast.makeText(getContext(), R.string.Empty_fields, Toast.LENGTH_LONG).show();
        });
    }
}
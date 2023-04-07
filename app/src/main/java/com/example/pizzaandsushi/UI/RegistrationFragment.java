package com.example.pizzaandsushi.UI;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pizzaandsushi.R;
import com.example.pizzaandsushi.UI.ProfileFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegistrationFragment extends Fragment {

    public RegistrationFragment() {
        super(R.layout.fragment_registration);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String filename = "User";
        Button button = view.findViewById(R.id.Profile_button);
        button.setOnClickListener(v -> {
            String Name = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_name)).getEditText().getText());
            String Email = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_email)).getEditText().getText());
            String Surname = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_surname)).getEditText().getText());
            String Telephone = String.valueOf(((TextInputLayout)view.findViewById(R.id.Profile_telephone)).getEditText().getText());

            File file = new File(getContext().getFilesDir(), filename);
            try (FileOutputStream fos = getContext().openFileOutput(filename, Context.MODE_PRIVATE)) {
                fos.write((Name + "\n").getBytes());
                fos.write((Surname + "\n").getBytes());
                fos.write((Email + "\n").getBytes());
                fos.write((Telephone + "\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!Name.equals("") && !Email.equals("") && !Surname.equals("") && !Telephone.equals("")) {
                Navigation.findNavController(view).navigate(R.id.action_RegistrationToProfile);
            }
            else
                Toast.makeText(getContext(), R.string.Empty_fields, Toast.LENGTH_LONG).show();
        });
    }
}
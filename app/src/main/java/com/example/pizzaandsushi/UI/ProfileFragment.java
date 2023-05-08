package com.example.pizzaandsushi.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.pizzaandsushi.DataSource.Room.DataBase;
import com.example.pizzaandsushi.DataSource.User;
import com.example.pizzaandsushi.R;
import com.example.pizzaandsushi.ViewModels.ViewPatternUser;

import java.util.List;

public class ProfileFragment extends Fragment {
    private ViewPatternUser viewPattern;

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPattern = new ViewModelProvider(this).get(ViewPatternUser.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*
        database.userDao().getUsers().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                if (users != null && users.size() > 0) {
                    for (User user : users) {
                        ((TextView)view.findViewById(R.id.NameProfile)).setText(user.getName());
                        ((TextView)view.findViewById(R.id.SurnameProfile)).setText(user.getSurname());
                        ((TextView)view.findViewById(R.id.TelephoneProfile)).setText(user.getTelephone());
                        ((TextView)view.findViewById(R.id.EmailProfile)).setText(user.getEmail());
                        if (user.getGender().equals("Male"))
                            ((ImageView)view.findViewById(R.id.Avatar)).setImageResource(R.mipmap.profile_man);
                        else if (user.getGender().equals("Female"))
                            ((ImageView)view.findViewById(R.id.Avatar)).setImageResource(R.mipmap.profile_woman);
                    }
                }
                else {
                    Navigation.findNavController(view).navigate(R.id.action_ProfileToRegistration);
                }
            }
        });
        */
        viewPattern.users.observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                if (users != null && users.size() > 0) {
                    for (User user : users) {
                        ((TextView)view.findViewById(R.id.NameProfile)).setText(user.getName());
                        ((TextView)view.findViewById(R.id.SurnameProfile)).setText(user.getSurname());
                        ((TextView)view.findViewById(R.id.TelephoneProfile)).setText(user.getTelephone());
                        ((TextView)view.findViewById(R.id.EmailProfile)).setText(user.getEmail());
                        if (user.getGender().equals("Male"))
                            ((ImageView)view.findViewById(R.id.Avatar)).setImageResource(R.mipmap.profile_man);
                        else if (user.getGender().equals("Female"))
                            ((ImageView)view.findViewById(R.id.Avatar)).setImageResource(R.mipmap.profile_woman);
                    }
                }
                else {
                    Navigation.findNavController(view).navigate(R.id.action_ProfileToRegistration);
                }
            }
        });
        ImageButton button1 = view.findViewById(R.id.Menu_button);
        button1.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_ProfileToMenu);
        });

        ImageButton button2 = view.findViewById(R.id.exit);
        button2.setOnClickListener(v -> {
            //database.userDao().deleteUser();
            Navigation.findNavController(view).navigate(R.id.action_ProfileToRegistration);
        });

        ImageButton button3 = view.findViewById(R.id.settings);
        button3.setOnClickListener(v -> {
            Bundle update = new Bundle();
            update.putBoolean("update", true);
            update.putString("Name", String.valueOf(((TextView)view.findViewById(R.id.NameProfile)).getText()));
            update.putString("Surname", String.valueOf(((TextView)view.findViewById(R.id.SurnameProfile)).getText()));
            update.putString("Telephone", String.valueOf(((TextView)view.findViewById(R.id.TelephoneProfile)).getText()));
            update.putString("Email", String.valueOf(((TextView)view.findViewById(R.id.EmailProfile)).getText()));
            update.putAll(update);
            Navigation.findNavController(view).navigate(R.id.action_ProfileToRegistration, update);
        });

        ImageButton button4 = view.findViewById(R.id.Basket_button);
        button4.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_ProfileToBasket);
        });
    }

}
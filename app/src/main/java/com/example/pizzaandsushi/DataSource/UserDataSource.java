package com.example.pizzaandsushi.DataSource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class UserDataSource {
    public static LiveData<List<User>> setInitialData(String name, String surname, String telephone, String email, String gender) {
        MutableLiveData<List<User>> result = new MutableLiveData<>();
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(name, surname, telephone, email, gender));
        result.setValue(users);
        return result;
    }
}

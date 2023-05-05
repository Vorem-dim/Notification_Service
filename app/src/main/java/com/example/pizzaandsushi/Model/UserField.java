package com.example.pizzaandsushi.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pizzaandsushi.DataSource.User;

import java.util.ArrayList;
import java.util.List;

public class UserField {
    public static LiveData<User> setInitialData() {
        MutableLiveData<User> result = new MutableLiveData<>();
        //User user = new User();
        //result.setValue(user);
        return result;
    }
}

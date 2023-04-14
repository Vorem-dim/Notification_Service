package com.example.pizzaandsushi.Repositoryes;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.pizzaandsushi.DataSource.MenuDataSource;
import com.example.pizzaandsushi.DataSource.Room.DataBase;
import com.example.pizzaandsushi.DataSource.Room.UserDao;
import com.example.pizzaandsushi.DataSource.User;
import com.example.pizzaandsushi.Model.MenuField;
import com.example.pizzaandsushi.Model.PositionField;
import com.example.pizzaandsushi.UserApp;

import java.util.ArrayList;
import java.util.List;

public class MenuRepos {
    private final UserDao userDao;
    private final LiveData<List<User>> users;
    DataBase database;

    public MenuRepos() {
        database = UserApp.instance.getDatabase();
        userDao = UserApp.instance.getDatabase().userDao();
        users = userDao.getUsers();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public LiveData<List<MenuField>> generateDataMenu(Context context) {
        return MenuDataSource.setInitialDataMenu(context);
    }

    public LiveData<ArrayList<ArrayList<PositionField>>> generateDataPosition(Context context) {
        return MenuDataSource.setInitialDataPosition(context);
    }
}
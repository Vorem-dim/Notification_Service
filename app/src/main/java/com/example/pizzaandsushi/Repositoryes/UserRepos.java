package com.example.pizzaandsushi.Repositoryes;

import androidx.lifecycle.LiveData;

import com.example.pizzaandsushi.DataSource.Room.DataBase;
import com.example.pizzaandsushi.DataSource.Room.UserDao;
import com.example.pizzaandsushi.DataSource.User;
import com.example.pizzaandsushi.DataSource.UserDataSource;
import com.example.pizzaandsushi.UserApp;

import java.util.List;

public class UserRepos {
    private final UserDao userDao;
    private final LiveData<List<User>> users;
    DataBase database;

    public UserRepos() {
        database = UserApp.instance.getDatabase();
        userDao = UserApp.instance.getDatabase().userDao();
        users = userDao.getUsers();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public LiveData<List<User>> generateData(String name, String surname, String telephone, String email, String gender) {
        return UserDataSource.setInitialData(name, surname, telephone, email, gender);
    }
}

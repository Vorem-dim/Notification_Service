package com.example.pizzaandsushi;

import android.app.Application;

import com.example.pizzaandsushi.DataSource.Room.DataBase;
import com.example.pizzaandsushi.DataSource.User;
import com.example.pizzaandsushi.Repositoryes.MenuRepos;
import com.example.pizzaandsushi.Repositoryes.UserRepos;

public class UserApp extends Application {
    public static UserApp instance;
    private DataBase database;
    private UserRepos repository;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = DataBase.getInstance(this);
        repository = new UserRepos();
    }

    public UserApp() {
        instance = this;
        database = DataBase.getInstance(this);
        repository = new UserRepos();
    }

    public DataBase getDatabase() {
        return database;
    }

    public UserRepos getRepository() {
        return repository;
    }
}

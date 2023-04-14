package com.example.pizzaandsushi;

import android.app.Application;

import com.example.pizzaandsushi.DataSource.Room.DataBase;
import com.example.pizzaandsushi.Repositoryes.MenuRepos;

public class UserApp extends Application {
    public static UserApp instance;
    private DataBase database;
    private MenuRepos repository;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = DataBase.getInstance(this);
        repository = new MenuRepos();
    }

    public DataBase getDatabase() {
        return database;
    }

    public MenuRepos getRepository() {
        return repository;
    }
}

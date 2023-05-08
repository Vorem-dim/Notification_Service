package com.example.pizzaandsushi.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.pizzaandsushi.DataSource.User;
import com.example.pizzaandsushi.Repositoryes.UserRepos;
import com.example.pizzaandsushi.UserApp;

import java.util.List;

public class ViewPatternUser extends ViewModel {
    public UserRepos userRepos;
    public LiveData<List<User>> users;

    public ViewPatternUser() {
        UserApp app = new UserApp();
        userRepos = app.instance.getRepository();
        users = userRepos.getUsers();
    }
}

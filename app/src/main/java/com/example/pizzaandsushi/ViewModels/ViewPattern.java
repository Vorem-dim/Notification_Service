package com.example.pizzaandsushi.ViewModels;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.pizzaandsushi.DataSource.User;
import com.example.pizzaandsushi.Model.MenuField;
import com.example.pizzaandsushi.Model.PositionField;
import com.example.pizzaandsushi.Repositoryes.MenuRepos;
import com.example.pizzaandsushi.UserApp;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("NotConstructor")
public class ViewPattern extends ViewModel {
    public MenuRepos userRepos;
    public LiveData<User> user;
    public LiveData<List<MenuField>> menu;
    public LiveData<ArrayList<ArrayList<PositionField>>> position;
    @SuppressLint("StaticFieldLeak")
    private Context context;

    public ViewPattern() {}

    public void initDataBase() {
        userRepos = UserApp.instance.getRepository();
        //user = userRepos.getUser();
    }

    public void initViewPattern(Context context) {
        this.context = context;
        MenuViewPattern();
        PositionViewPattern();
    }

    public void MenuViewPattern() {
        MenuRepos repositmenu = new MenuRepos();
        menu = repositmenu.generateDataMenu(context);
    }

    public void PositionViewPattern() {
        MenuRepos repositposition = new MenuRepos();
        position = repositposition.generateDataPosition(context);
    }
}
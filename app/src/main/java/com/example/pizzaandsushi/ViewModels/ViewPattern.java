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

public class ViewPattern extends ViewModel {
    MenuRepos Repository;
    public LiveData<List<MenuField>> menu;
    public LiveData<ArrayList<ArrayList<PositionField>>> position;
    @SuppressLint("StaticFieldLeak")
    private Context context;

    public ViewPattern() {
        Repository = new MenuRepos();
    }

    public void initViewPattern(Context context) {
        this.context = context;
        MenuViewPattern();
        PositionViewPattern();
    }

    public void MenuViewPattern() {
        menu = Repository.generateDataMenu(context);
    }

    public void PositionViewPattern() {
        position = Repository.generateDataPosition(context);
    }
}
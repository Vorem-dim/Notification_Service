package com.example.pizzaandsushi.ViewModels;

import android.annotation.SuppressLint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.pizzaandsushi.Model.MenuField;
import com.example.pizzaandsushi.Model.PositionField;
import com.example.pizzaandsushi.Repositoryes.MenuRepos;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("NotConstructor")
public class ViewPattern extends ViewModel {
    public LiveData<List<MenuField>> menu;
    public LiveData<ArrayList<ArrayList<PositionField>>> position;

    public ViewPattern() {
        MenuViewPattern();
        PositionViewPattern();
    }

    public void MenuViewPattern() {
        MenuRepos repositmenu = new MenuRepos();
        menu = repositmenu.generateDataMenu();
    }

    public void PositionViewPattern() {
        MenuRepos repositposition = new MenuRepos();
        position = repositposition.generateDataPosition();
    }
}
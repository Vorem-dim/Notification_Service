package com.example.pizzaandsushi.Repositoryes;

import androidx.lifecycle.LiveData;

import com.example.pizzaandsushi.DataSource.MenuDataSource;
import com.example.pizzaandsushi.Model.MenuField;
import com.example.pizzaandsushi.Model.PositionField;

import java.util.ArrayList;
import java.util.List;

public class MenuRepos {
    public LiveData<List<MenuField>> generateDataMenu() {
        return MenuDataSource.setInitialDataMenu();
    }

    public LiveData<ArrayList<ArrayList<PositionField>>> generateDataPosition() {
        return MenuDataSource.setInitialDataPosition();
    }
}

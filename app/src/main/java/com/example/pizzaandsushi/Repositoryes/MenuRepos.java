package com.example.pizzaandsushi.Repositoryes;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.pizzaandsushi.DataSource.MenuDataSource;
import com.example.pizzaandsushi.Model.MenuField;
import com.example.pizzaandsushi.Model.PositionField;

import java.util.ArrayList;
import java.util.List;

public class MenuRepos {
    public LiveData<List<MenuField>> generateDataMenu(Context context) {
        return MenuDataSource.setInitialDataMenu(context);
    }

    public LiveData<ArrayList<ArrayList<PositionField>>> generateDataPosition(Context context) {
        return MenuDataSource.setInitialDataPosition(context);
    }
}
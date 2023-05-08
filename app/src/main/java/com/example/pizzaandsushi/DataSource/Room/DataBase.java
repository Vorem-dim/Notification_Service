package com.example.pizzaandsushi.DataSource.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pizzaandsushi.DataSource.User;

@Database (entities = {User.class}, version = 5)
public abstract class DataBase extends RoomDatabase {
    private static final String DataBase_name = "user_info";
    private static DataBase instance;

    public static synchronized DataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, DataBase_name)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract UserDao userDao();
}
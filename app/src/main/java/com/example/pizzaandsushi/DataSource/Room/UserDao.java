package com.example.pizzaandsushi.DataSource.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pizzaandsushi.DataSource.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    LiveData<List<User>> getUsers();

    @Query("UPDATE users SET name=:name, surname=:surname, telephone=:telephone, gender=:gender, email=:email")
    void updateUser(String name, String surname, String telephone, String email, String gender);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser(User user);

    @Delete
    void deleteUser(User user);
}
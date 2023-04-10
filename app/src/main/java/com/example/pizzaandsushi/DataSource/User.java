package com.example.pizzaandsushi.DataSource;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "users")
public class User {
    @ColumnInfo (name = "Name")
    private String name;
    @ColumnInfo (name = "Surname")
    private String surname;
    @ColumnInfo (name = "Telephone")
    private String telephone;
    @PrimaryKey
    @NonNull
    private String email;
    @ColumnInfo (name = "Gender")
    private String gender;

    public User(String name, String surname, String telephone, @NonNull String email, String gender) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephone() {
        return telephone;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
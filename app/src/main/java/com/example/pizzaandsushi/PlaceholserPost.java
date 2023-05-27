package com.example.pizzaandsushi;

public class PlaceholserPost {
    private int userID;
    private int id;
    private String title;
    public String body;

    public int getUserID() {
        return userID;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

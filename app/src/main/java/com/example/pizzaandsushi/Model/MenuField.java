package com.example.pizzaandsushi.Model;

public class MenuField {
    private int image;
    private String text;

    public MenuField(String text, int image) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return this.image;
    }

    public String getText() {
        return this.text;
    }
}
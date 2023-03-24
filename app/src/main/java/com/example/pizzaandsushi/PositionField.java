package com.example.pizzaandsushi;

public class PositionField {
    private int image;
    private String title;
    private String text;

    public PositionField(String text, int image, String title) {
        this.image = image;
        this.title = title;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}

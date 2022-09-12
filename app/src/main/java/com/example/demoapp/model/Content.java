package com.example.demoapp.model;

public class Content {
    private String text;

    private final int imageRoute;

    public Content(String text, int imageRoute) {
        this.text = text;
        this.imageRoute = imageRoute;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageRoute() {
        return imageRoute;
    }

}

package com.example.demoapp.model;

public class Content {
    private Long id;
    private String caption;
    private int resourceInt;

    public Content() {
    }

    public Content(Long id, String caption, int resourceInt) {
        this.id= id;
        this.caption = caption;
        this.resourceInt = resourceInt;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getResourceInt() {
        return resourceInt;
    }

    public void setResourceInt(int resourceInt) {
        this.resourceInt = resourceInt;
    }
}

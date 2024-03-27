package com.test;

public enum Size {
    LARGE("Большая"),
    MEDIUM("Средняя"),
    SMALL("Маленькая");

    private String title;

    public String getTitle(){
        return title;
    }
    Size(String title) {
        this.title = title;
    }
}

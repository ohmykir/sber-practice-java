package com.test;

public enum Color {
    BLUE("синий"),
    RED("красный"),
    YELLOW("желтый"),
    GREEN("зеленый"),
    WHITE("белый"),
    BLACK("черный");

    private String title;

    public String getTitle(){
        return this.title;
    }
    Color(String title) {
        this.title = title;
    }
}

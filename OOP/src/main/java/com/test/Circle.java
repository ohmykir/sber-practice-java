package com.test;

public class Circle {
    private double radius;
    private Color color;

    public Circle(double radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        String s = String.format("radius: %.3f, color: %s, area: %.3f, perimeter: %.3f",
                this.radius, this.color, this.area(), this.perimeter());
        return s;
    }
}

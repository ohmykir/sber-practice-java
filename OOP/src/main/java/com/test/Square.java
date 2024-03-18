package com.test;

public class Square extends Figure implements Drawable{
    private double size;

    public Square(Point point) {
        super(point);
    }

    @Override
    public double area() {
        return this.size*this.size;
    }

    @Override
    public double perimeter() {
        return this.size*4;
    }

    @Override
    public void draw() {
        System.out.println("Нарисован черный квадрат с центром: x = " + this.point.getX() + ", y = " + this.point.getY());
    }

    @Override
    public void draw(Color color) {
        System.out.println("Нарисован "+ color.getTitle() + " квадрат с центром: x = " + this.point.getX() + ", y = " + this.point.getY());
    }
}

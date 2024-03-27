package com.test;

public class Rectangle extends Figure implements Drawable {
    private double length;
    private double width;

    public Rectangle(Point point) {
        super(point);
    }

    @Override
    public double area() {
        return this.length * this.width;
    }

    @Override
    public double perimeter() {
        return 2 * (this.length + this.width);
    }

    @Override
    public void draw() {
        System.out.println("Нарисован черный прямоугольник с центром: x = " + this.point.getX() + ", y = " + this.point.getY());
    }

    @Override
    public void draw(Color color) {
        System.out.println("Нарисован " + color.getTitle() + " прямоугольник с центром: x = " + this.point.getX() + ", y = " + this.point.getY());
    }
}

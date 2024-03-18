package com.test;

public class Triangle extends Figure implements Drawable{
    private double size1;
    private double size2;
    private double size3;

    public Triangle(Point point) {
        super(point);
    }

    @Override
    public double area() {
        double p = this.perimeter();
        return Math.sqrt(p*(p-this.size1)*(p-this.size2)*(p-this.size3));
    }

    @Override
    public double perimeter() {
        return this.size1 + this.size2 + this.size3;
    }

    @Override
    public void draw() {
        System.out.println("Нарисован черный треугольник с центром: x = " + this.point.getX() + ", y = " + this.point.getY());
    }

    @Override
    public void draw(Color color) {
        System.out.println("Нарисован "+ color.getTitle() + " треугольник с центром: x = " + this.point.getX() + ", y = " + this.point.getY());
    }
}

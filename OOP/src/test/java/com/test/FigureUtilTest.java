package com.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigureUtilTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void drawCircleTest() {
        Drawable circle = new CirclePaint(new Point(6, 6));
        circle.draw();
        circle.draw(Color.GREEN);

        assertEquals("Нарисован черный круг с центром: x = 6, y = 6\r\n" +
                "Нарисован зеленый круг с центром: x = 6, y = 6", outputStreamCaptor.toString().trim());
    }

    @Test
    public void drawTriangleTest() {
        Drawable triangle = new Triangle(new Point(1, 10));
        triangle.draw();
        triangle.draw(Color.BLUE);

        assertEquals("Нарисован черный треугольник с центром: x = 1, y = 10\r\n" +
                "Нарисован синий треугольник с центром: x = 1, y = 10", outputStreamCaptor.toString().trim());
    }

    @Test
    public void drawSquareTest() {
        Drawable square = new Square(new Point(2, 3));
        square.draw();
        square.draw(Color.RED);

        assertEquals("Нарисован черный квадрат с центром: x = 2, y = 3\r\n" +
                "Нарисован красный квадрат с центром: x = 2, y = 3", outputStreamCaptor.toString().trim());
    }

    @Test
    public void drawRectangleTest() {
        Drawable rectangle = new Rectangle(new Point(3, 1));
        rectangle.draw();
        rectangle.draw(Color.YELLOW);

        assertEquals("Нарисован черный прямоугольник с центром: x = 3, y = 1\r\n" +
                "Нарисован желтый прямоугольник с центром: x = 3, y = 1", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}

package com.test;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {
    @Test
    public void firstTest(){
        Circle circle = new Circle(5, Color.BLUE);

        assertEquals(78.53981633974483, circle.area());
        assertEquals(31.41592653589793, circle.perimeter());
    }

    @Test
    public void secondTest(){
        Circle circle = new Circle(1, Color.RED);

        assertEquals(Math.PI, circle.area());
        assertEquals(6.283185307179586, circle.perimeter());
    }

    @Test
    public void toStringTest(){
        Circle circle = new Circle(5, Color.BLUE);
        Circle circle2 = new Circle(1, Color.RED);

        assertEquals("radius: 5,000, color: java.awt.Color[r=0,g=0,b=255], area: 78,540, perimeter: 31,416",
                circle.toString());
        assertEquals("radius: 1,000, color: java.awt.Color[r=255,g=0,b=0], area: 3,142, perimeter: 6,283",
                circle2.toString());
    }

}

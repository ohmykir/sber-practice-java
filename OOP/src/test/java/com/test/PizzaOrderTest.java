package com.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void orderTest(){
        PizzaOrder pizzaOrder = new PizzaOrder("Margarita", Size.LARGE, true, "Kozlenskaya, 33");
        assertEquals("PizzaOrder{Name = 'Margarita', size = LARGE, isSousNeeded = true," +
                " address = 'Kozlenskaya, 33', isAccepted = false}", pizzaOrder.toString());

        pizzaOrder.order();
        assertEquals("Заказ принят. Большая пицца 'Margarita' с соусом на адрес Kozlenskaya, 33",
                outputStreamCaptor.toString().trim());
    }

    @Test
    public void cancelTest(){
        PizzaOrder pizzaOrder = new PizzaOrder("Margarita", Size.LARGE, true, "Kozlenskaya, 33");
        pizzaOrder.cancel();

        assertEquals("Заказ отменен.", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown(){
        System.setOut(standardOut);
    }
}
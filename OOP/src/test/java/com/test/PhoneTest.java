package com.test;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneTest{
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void receiveCallTest(){
        Phone phoneOne = new Phone();
        Phone phoneTwo = new Phone("88005553535", "iPhone X");

        phoneOne.receiveCall("Коля");
        assertEquals("Звонит: Коля", outputStreamCaptor.toString().trim());

        phoneOne.receiveCall("Петя", phoneTwo.getNumber());
        assertEquals("Звонит: Коля\r\nЗвонит: Петя (88005553535)", outputStreamCaptor.toString().trim());
    }

    @Test
    public void toStringTest(){
        Phone phoneTwo = new Phone("88005553535", "iPhone X");
        Phone phoneThree = new Phone("+79990002255", "Nokia3310", 350);

        assertEquals("Номер: 88005553535; модель: iPhone X; вес: 0.0", phoneTwo.toString());
        assertEquals("Номер: +79990002255; модель: Nokia3310; вес: 350.0", phoneThree.toString());
    }
    @Test
    public void sendMessageTest(){
        Phone phone = new Phone();
        String[] numbers = new String[3];
        numbers[0] = "554477";
        numbers[1] = "89517412391";
        numbers[2] = "232323";
        phone.sendMessage(numbers);

        assertEquals("554477\r\n89517412391\r\n232323", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown(){
        System.setOut(standardOut);
    }

}
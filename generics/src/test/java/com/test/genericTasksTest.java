package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;


public class genericTasksTest {
    private static final ArrayList<Integer> list = new ArrayList<>();

    @Test
    public void countEvenTest1() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        assertEquals(5, genericTasks.countEven(list));
    }

    @Test
    public void countEvenTest2() {
        for (int i = 1; i < 30; i = i + 2) {
            list.add(i);
        }

        assertEquals(0, genericTasks.countEven(list));
    }

    @Test
    public void countEvenTest3() {
        for (int i = 0; i < 30; i = i + 2) {
            list.add(i);
        }

        assertEquals(15, genericTasks.countEven(list));
    }

    @Test
    public void swapElementsTest(){
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        genericTasks.swapElements(list, 0, 9);
        assertEquals(9, list.get(0));
        assertEquals(0, list.get(9));
    }
}

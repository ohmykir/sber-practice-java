package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompletingTasksTest {

    @Test
    public void averageTest() {
        double result = CompletingTasks.average();
        assertTrue(result >= 10 && result <= 99);
    }

    @Test
    public void countSCTest() {
        assertEquals(CompletingTasks.countSC(), 50);
    }

    @Test
    public void stringToBooleanTest() {
        CompletingTasks object = new CompletingTasks();

        assertFalse(object.stringToBoolean("1010101010"));
        assertTrue(object.stringToBoolean("1111111111"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                    () -> object.stringToBoolean("10101"));
        assertTrue(exception.getMessage().contains("String must contain 10 '1' or '0' characters"));
    }
}

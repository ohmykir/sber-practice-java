package com.test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ThirdClassTest {

    @Test
    public void testWithMock() {
        FirstClass objectOne = mock(FirstClass.class);
        doNothing().when(objectOne).methodA();
        doNothing().when(objectOne).methodB();

        SecondClass objectTwo = mock(SecondClass.class);
        doNothing().when(objectTwo).methodC();
        doNothing().when(objectTwo).methodD();

        ThirdClass mainObject = new ThirdClass();

        assertEquals("Stop!", mainObject.methodE(objectOne, objectTwo));
        verify(objectOne, times(1)).methodB();
        verify(objectTwo, times(1)).methodD();
    }

    @Test
    public void countCalls() {
        FirstClass fObj = new FirstClass();
        SecondClass sObj = new SecondClass();
        ThirdClass thObj = new ThirdClass();

        thObj.methodE(fObj, sObj);
        assertEquals(1, fObj.count);
        assertEquals(1, sObj.count);
    }

    @Test
    public void throwingExceptionTest() {
        ThirdClass object = new ThirdClass();
        Exception exception = assertThrows(Exception.class, object::throwingException);
        assertTrue(exception.getMessage().contains("Throwing Exception"));
    }

    @Test
    public void privateMethodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ThirdClass object = new ThirdClass();
        Method method = ThirdClass.class.getDeclaredMethod("privateMethod");
        method.setAccessible(true);
        String result = (String) method.invoke(object);
        assertEquals("I`m private method!", result);
    }
}
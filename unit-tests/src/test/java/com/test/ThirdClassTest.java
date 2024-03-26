package com.test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ThirdClassTest {

    @Test
    public void testWithMock(){
        FirstClass objectOne = mock(FirstClass.class);
        SecondClass objectTwo = mock(SecondClass.class);
        ThirdClass mainObject = new ThirdClass();

        assertEquals("Stop!", mainObject.methodE(objectOne, objectTwo));
    }

    @Test
    public void countCalls(){
        FirstClass fObj = new FirstClass();
        SecondClass sObj = new SecondClass();
        ThirdClass thObj = new ThirdClass();

        thObj.methodE(fObj, sObj);
        assertEquals(1, fObj.count);
        assertEquals(1, sObj.count);
    }

    @Test
    public void throwingExceptionTest(){
        ThirdClass object = new ThirdClass();
        assertThrows(Exception.class, object::throwingException);
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
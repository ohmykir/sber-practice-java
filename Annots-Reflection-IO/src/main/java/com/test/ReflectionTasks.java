package com.test;

import java.lang.reflect.Field;

public class ReflectionTasks {

    public static void taskOne() throws ClassNotFoundException {
        DataContainer data = new DataContainer();
        Field[] fields = data.getClass().getFields();
        creation(fields);
    }

    public static void creation(Field[] fields) throws ClassNotFoundException {

    }
}

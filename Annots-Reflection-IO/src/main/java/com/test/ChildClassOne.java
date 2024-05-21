package com.test;

import lombok.NonNull;

@Inheritance(dayOfWeek = 5)
public class ChildClassOne extends ParentClass {
    @RepeatableAnnotation(hour = 1, priority = 3, description = "methodOne")
    public static DataContainer methodOne(@NonNull DataContainer data) {
        int value = data.getValue() * 2;
        String message = data.getName() + " Yo!";
        boolean isTrue = true;

        return new DataContainer(value, message, isTrue);
    }

    @RepeatableAnnotation(hour = 3, priority = 0, description = "methodTwo")
    public static DataContainer methodTwo(@NonNull DataContainer data) {
        int value = data.getValue() * 4;
        String message = data.getName() + " Ho!";
        boolean isTrue = false;

        return new DataContainer(value, message, isTrue);
    }
}
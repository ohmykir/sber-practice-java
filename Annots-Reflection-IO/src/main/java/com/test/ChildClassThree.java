package com.test;

import lombok.NonNull;

@Inheritance(dayOfWeek = 2)
public class ChildClassThree extends ParentClass {
    @RepeatableAnnotation(hour = 2, priority = 6, description = "methodOne")
    public static DataContainer methodOne(@NonNull DataContainer data) {
        int value = data.getValue() * 999;
        String message = data.getName() + " Bey!";
        boolean isTrue = !true;

        return new DataContainer(value, message, isTrue);
    }

    @RepeatableAnnotation(hour = 0, priority = 100, description = "methodTwo")
    public static DataContainer methodTwo(@NonNull DataContainer data) {
        int value = data.getValue() * 0;
        String message = data.getName() + "!!!!";
        boolean isTrue = false;

        return new DataContainer(value, message, isTrue);
    }
}

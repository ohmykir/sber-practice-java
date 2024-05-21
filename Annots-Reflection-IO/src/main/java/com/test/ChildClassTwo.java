package com.test;

import lombok.NonNull;

public class ChildClassTwo extends ParentClass {
    @RepeatableAnnotation(hour = 10, priority = 10, description = "method")
    public static DataContainer method(@NonNull DataContainer data) {
        int value = data.getValue() * 10;
        String message = data.getName() + " heeeey!";
        boolean isTrue = true;

        return new DataContainer(value, message, isTrue);
    }
}

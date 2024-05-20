package com.test;

import lombok.NonNull;

@Inheritance(dayOfWeek = 5)
public class ChildClassOne extends ParentClass {
    @RepeatableAnnotation(hour = 1, priority = 3, description = "methodOne")
    public static void methodOne(@NonNull DataContainer data) {
    }

    @RepeatableAnnotation(hour = 3, priority = 0, description = "methodTwo")
    private void methodTwo(@NonNull DataContainer data) {
    }
}
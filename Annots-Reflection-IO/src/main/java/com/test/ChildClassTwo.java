package com.test;

import lombok.NonNull;

public class ChildClassTwo extends ParentClass {
    @RepeatableAnnotation(hour = 10, priority = 10, description = "method")
    public static void method(@NonNull DataContainer data) {
    }
}

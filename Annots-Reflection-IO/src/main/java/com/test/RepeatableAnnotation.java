package com.test;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Repeatable(RepeatableAnnotations.class)
public @interface RepeatableAnnotation {
    int hour();

    int priority();

    String description();
}

@Target(ElementType.METHOD)
@interface RepeatableAnnotations {
    RepeatableAnnotation[] value();
}

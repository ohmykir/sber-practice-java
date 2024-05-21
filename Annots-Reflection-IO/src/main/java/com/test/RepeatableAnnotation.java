package com.test;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RepeatableAnnotations.class)
public @interface RepeatableAnnotation {
    int hour();

    int priority();

    String description();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface RepeatableAnnotations {
    RepeatableAnnotation[] value();
}

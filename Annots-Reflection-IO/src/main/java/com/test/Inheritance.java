package com.test;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.TYPE)
public @interface Inheritance {
    int dayOfWeek();
}

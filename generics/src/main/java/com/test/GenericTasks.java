package com.test;

import java.util.*;

public class GenericTasks {
    public static <T extends Number> int countEven(Collection<T> collection) {
        int count = 0;
        for (T element : collection) {
            if (element.intValue() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void swapElements(List<?> list, int index1, int index2) {
        final List l = list;

        l.set(index1, l.set(index2, l.get(index1)));
    }
}

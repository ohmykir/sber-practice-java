package com.test;

import java.util.*;
import java.util.stream.*;

public class CompletingTasks {
    public static double average() {
        IntStream ints = IntStream.of(3, 8, 54, 63, 45, 245, 553, 1533, 34, 86);
        double result = ints.filter(x -> x / 10 > 0 && x / 100 < 1)
                            .average()
                            .getAsDouble();
        return result;
    }

    public static Map<Long, String> getMap() {
        Stream<String> strings = Stream.of("a", "b", "c", "d", "e", "f", "g", "h");

        return strings.map(x -> new StreamContainer(x, (long) (Math.random() * 1000)))
                .peek(x -> System.out.println(x.getCount()))
                .collect(Collectors.toMap(StreamContainer::getCount, StreamContainer::getName));
    }

    public static int countSC() {
        Map<String, List<StreamContainer>> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            List<StreamContainer> list = createList();
            map.put(String.valueOf(i), list);
        }

        List<StreamContainer> list = map.values()
                                        .stream()
                                        .flatMap(List::stream)
                                        .collect(Collectors.toList());

        return (int) list.stream().count(); //даже идея говорит что можно заменить на size()
    }

    public boolean stringToBoolean(String s) {
        if (s.matches("[0-1]*") && s.length() == 10) {
            return s.chars().mapToObj(x -> x == 49).reduce((x, y) -> x && y).get();
        } else {
            throw new IllegalArgumentException("String must contain 10 '1' or '0' characters");
        }
    }

    private static List<StreamContainer> createList() {
        List<StreamContainer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new StreamContainer(String.valueOf(i), (long) (Math.random() * 1000)));
        }
        return list;
    }
}
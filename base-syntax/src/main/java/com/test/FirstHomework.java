package com.test;

public class FirstHomework {
    public static void method1() {
        for (int i = 1; i < 100; i++) {
            if (i%7 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void method2() {
        int[] array = new int[10];
        int max = 0;
        int average = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*100);
            max = Math.max(max, array[i]);
            average = (average + array[i])/2;
        }
        System.out.println("Max value: " + max + " Average value: " + average);
    }
    public static void method3() {
        for (int i = 0; i < 100; i++) {
            boolean composite = false;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i%j == 0) {
                    composite = true;
                };
            }
            if (!composite) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void method4() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        method1();
        method2();
        method3();
        method4();
    }
}
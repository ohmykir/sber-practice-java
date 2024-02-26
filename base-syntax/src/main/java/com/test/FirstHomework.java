package com.test;

public class FirstHomework {
    private static void method1() {
        for (int number = 1; number < 100; number++) {
            if (number % 7 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
    private static void method2() {
        int[] array = new int[10];
        int maxValue = 0;
        int averageValue = 0;
        for (int index = 0; index < array.length; index++) {
            array[index] = (int) (Math.random()*100);
            maxValue = Math.max(maxValue, array[index]);
            averageValue = (averageValue + array[index])/2;
        }
        System.out.println("Max value: " + maxValue + " Average value: " + averageValue);
    }
    private static void method3() {
        for (int number = 0; number < 100; number++) {
            boolean composite = false;
            for (int divider = 2; divider < Math.sqrt(number); divider++) {
                if (number % divider == 0) {
                    composite = true;
                    break;
                }
            }
            if (!composite) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
    private static void method4() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 5; column++) {
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
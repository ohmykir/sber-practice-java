package com.test;

public class FirstHomework {
    private static void printDivisorsOfSeven() {
        for (int number = 1; number < 100; number++) {
            if (number % 7 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static void findMaxAndAverage() {
        int[] array = new int[10];
        int maxValue = 0;
        int averageValue = 0;
        for (int index = 0; index < array.length; index++) {
            array[index] = (int) (Math.random() * 100);
            maxValue = Math.max(maxValue, array[index]);
            averageValue = (averageValue + array[index]) / 2;
        }
        System.out.println("Max value: " + maxValue + " Average value: " + averageValue);
    }

    private static void printFirstPrimes() {
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

    private static void printSnowflakes() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 5; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printDivisorsOfSeven();
        findMaxAndAverage();
        printFirstPrimes();
        printSnowflakes();
    }
}
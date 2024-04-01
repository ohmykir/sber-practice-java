package com.test;

public class SecondClass {
    public int count = 0;

    public void methodC() {
        System.out.println("Done!");
    }

    public void methodD() {
        FirstClass firstObject = new FirstClass();
        this.count++;
        firstObject.methodA();
        System.out.println("methodA called");
    }
}
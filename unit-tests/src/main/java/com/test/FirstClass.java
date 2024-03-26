package com.test;

public class FirstClass {
    public int count;
    public void methodA(){
        System.out.println("Done!");
    }
    public void methodB(){
        SecondClass secondObject = new SecondClass();
        this.count++;
        secondObject.methodC();
        System.out.println("methodC called");
    }
}
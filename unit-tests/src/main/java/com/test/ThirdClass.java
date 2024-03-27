package com.test;

public class ThirdClass {
    public String methodE(FirstClass firstObject, SecondClass secondObject) {
        firstObject.methodB();
        secondObject.methodD();
        return "Stop!";
    }

    public void throwingException() throws Exception {
        throw new Exception("Throwing Exception");
    }

    private String privateMethod() {
        return "I`m private method!";
    }
}
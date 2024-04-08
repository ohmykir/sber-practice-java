package com.test;

public interface Service {
    boolean requestIsValid(String request);

    boolean responseIsValid(String response);

    String interaction(String request);

}

package com.test;

public class ServiceOneInteraction implements Service {
    @Override
    public boolean requestIsValid(String request) {
        return request.length() > 5;
    }

    @Override
    public boolean responseIsValid(String response) {
        return response.length() > 1;
    }

    @Override
    public String interaction(String request) {
        return requestIsValid(request) ? "YES" : "NO";
    }
}

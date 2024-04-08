package com.test;

public class ServiceTwoInteraction implements Service {
    @Override
    public boolean requestIsValid(String request) {
        return request.length() > 3;
    }

    @Override
    public boolean responseIsValid(String response) {
        return response.length() > 2;
    }

    @Override
    public String interaction(String request) {
        return requestIsValid(request) ? "YES" : "NO";
    }
}

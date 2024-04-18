package com.test;

public abstract class AnyServiceInteraction<T extends Service> {
    public void interaction(T service, String request) {
        if (service.requestIsValid(request)) {
            String response = service.interaction(request);
            if (service.responseIsValid(response)) {
                System.out.println(response);
            } else {
                System.out.println("Invalid response");
            }
        } else {
            System.out.println("Invalid request");
        }
    }
}
package com.test;

public class InvalidCardNumberException extends BankOnlineException {
    public InvalidCardNumberException() {
        super();
    }

    public InvalidCardNumberException(String message) {
        super(message);
    }
}

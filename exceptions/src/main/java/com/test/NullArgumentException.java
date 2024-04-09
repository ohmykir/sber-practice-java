package com.test;

public class NullArgumentException extends BankOnlineException {
    public NullArgumentException() {
        super();
    }

    public NullArgumentException(String message) {
        super(message);
    }
}

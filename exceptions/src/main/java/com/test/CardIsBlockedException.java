package com.test;

public class CardIsBlockedException extends BankOnlineException {
    public CardIsBlockedException() {
        super();
    }

    public CardIsBlockedException(String message) {
        super(message);
    }
}

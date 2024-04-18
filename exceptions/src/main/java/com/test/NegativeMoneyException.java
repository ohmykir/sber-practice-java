package com.test;

public class NegativeMoneyException extends BankOnlineException {
    public NegativeMoneyException() {
        super();
    }

    public NegativeMoneyException(String message) {
        super(message);
    }
}

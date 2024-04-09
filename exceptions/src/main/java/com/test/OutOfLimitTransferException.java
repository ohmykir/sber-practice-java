package com.test;

public class OutOfLimitTransferException extends BankOnlineException {
    public OutOfLimitTransferException() {
        super();
    }

    public OutOfLimitTransferException(String message) {
        super(message);
    }
}

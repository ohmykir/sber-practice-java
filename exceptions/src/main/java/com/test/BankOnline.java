package com.test;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class BankOnline {
    static String[] blockedCards = {"1111 1111 1111 1111",
            "2222 2222 2222 2222",
            "3333 3333 3333 3333"};

    static final int limit = 50000;

    public void send(String cardNumber, Double money) throws BankOnlineException {
        if (cardNumber == null) {
            throw new NullArgumentException("Null argument");
        } else if (cardIsBlocked(cardNumber)) {
            throw new CardIsBlockedException("Card is blocked");
        } else if (money < 0) {
            throw new NegativeMoneyException("Negative money");
        } else if (money > limit) {
            throw new OutOfLimitTransferException("Out of limit");
        } else if (!rightCardNumber(cardNumber)) {
            throw new InvalidCardNumberException("Invalid card number");
        } else {
            System.out.println("OK");
        }
    }

    private boolean rightCardNumber(String cardNumber) {
        cardNumber = Arrays.stream(cardNumber.split(" ")).collect(joining(""));
        return cardNumber.matches("[0-9]*") && cardNumber.length() == 16;
    }

    private boolean cardIsBlocked(String cardNumber) {
        return Arrays.asList(blockedCards).contains(cardNumber);
    }
}
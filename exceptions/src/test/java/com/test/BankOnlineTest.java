package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankOnlineTest {
    private static final BankOnline bankOnline = new BankOnline();

    @Test
    public void invalidCardNumberTest() {
        InvalidCardNumberException exception = assertThrows(InvalidCardNumberException.class,
                () -> bankOnline.send("aaaa bbbb cccc dddd", 500D));
        assertTrue(exception.getMessage().contains("Invalid card number"));

        InvalidCardNumberException exception2 = assertThrows(InvalidCardNumberException.class,
                () -> bankOnline.send("1111 2222 3333", 500D));
        assertTrue(exception2.getMessage().contains("Invalid card number"));
    }

    @Test
    public void cardIsBlockedTest() {
        CardIsBlockedException exception = assertThrows(CardIsBlockedException.class,
                () -> bankOnline.send("2222 2222 2222 2222", 500D));
        assertTrue(exception.getMessage().contains("Card is blocked"));
    }

    @Test
    public void negativeMoneyTest() {
        NegativeMoneyException exception = assertThrows(NegativeMoneyException.class,
                () -> bankOnline.send("2222 2222 2222 3333", -3456D));
        assertTrue(exception.getMessage().contains("Negative money"));
    }

    @Test
    public void nullArgumentTest() {
        NullArgumentException exception = assertThrows(NullArgumentException.class,
                () -> bankOnline.send(null, 500D));
        assertTrue(exception.getMessage().contains("Null argument"));
    }

    @Test
    public void outOfLimitTransferTest() {
        OutOfLimitTransferException exception = assertThrows(OutOfLimitTransferException.class,
                () -> bankOnline.send("1234 5678 9012 3456", 500000D));
        assertTrue(exception.getMessage().contains("Out of limit"));
    }

    @Test
    public void noExceptions() {
        assertDoesNotThrow(() -> bankOnline.send("1234 5678 9012 3456", 500D));
    }
}
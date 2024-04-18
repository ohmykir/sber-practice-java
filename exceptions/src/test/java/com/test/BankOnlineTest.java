package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankOnlineTest {
private static final BankOnline BANK_ONLINE = new BankOnline();

    @Test
    public void invalidCardNumberTest() {
        InvalidCardNumberException exception = assertThrows(InvalidCardNumberException.class,
                () -> BANK_ONLINE.send("aaaa bbbb cccc dddd", 500D));
        assertTrue(exception.getMessage().contains("Invalid card number"));

        InvalidCardNumberException exception2 = assertThrows(InvalidCardNumberException.class,
                () -> BANK_ONLINE.send("1111 2222 3333", 500D));
        assertTrue(exception2.getMessage().contains("Invalid card number"));
    }

    @Test
    public void cardIsBlockedTest() {
        CardIsBlockedException exception = assertThrows(CardIsBlockedException.class,
                () -> BANK_ONLINE.send("2222 2222 2222 2222", 500D));
        assertTrue(exception.getMessage().contains("Card is blocked"));
    }

    @Test
    public void negativeMoneyTest() {
        NegativeMoneyException exception = assertThrows(NegativeMoneyException.class,
                () -> BANK_ONLINE.send("2222 2222 2222 3333", -3456D));
        assertTrue(exception.getMessage().contains("Negative money"));
    }

    @Test
    public void nullArgumentTest() {
        NullArgumentException exception = assertThrows(NullArgumentException.class,
                () -> BANK_ONLINE.send(null, 500D));
        assertTrue(exception.getMessage().contains("Null argument"));
    }

    @Test
    public void outOfLimitTransferTest() {
        OutOfLimitTransferException exception = assertThrows(OutOfLimitTransferException.class,
                () -> BANK_ONLINE.send("1234 5678 9012 3456", 500000D));
        assertTrue(exception.getMessage().contains("Out of limit"));
    }

    @Test
    public void noExceptions() {
        assertDoesNotThrow(() -> BANK_ONLINE.send("1234 5678 9012 3456", 500D));
    }
}
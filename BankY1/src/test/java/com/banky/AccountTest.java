package com.banky;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	@Test
    public void testDeposit() {
        Account account = new Account("123", "John Doe", 100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        Account account = new Account("123", "John Doe", 100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    public void testTransfer() {
        Account account1 = new Account("123", "John Doe", 100.0);
        Account account2 = new Account("456", "Jane Doe", 50.0);
        account1.transfer(account2, 30.0);
        assertEquals(70.0, account1.getBalance(), 0.001);
        assertEquals(80.0, account2.getBalance(), 0.001);
    }
}

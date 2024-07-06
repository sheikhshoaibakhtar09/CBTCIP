package com.banky;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {
	@Test
    public void testCreateAccount() {
        Bank bank = new Bank();
        bank.createAccount("123", "John Doe", 100.0);
        assertNotNull(bank.getAccount("123"));
    }

    @Test
    public void testDeposit() {
        Bank bank = new Bank();
        bank.createAccount("123", "John Doe", 100.0);
        bank.deposit("123", 50.0);
        assertEquals(150.0, bank.getAccount("123").getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        Bank bank = new Bank();
        bank.createAccount("123", "John Doe", 100.0);
        bank.withdraw("123", 50.0);
        assertEquals(50.0, bank.getAccount("123").getBalance(), 0.001);
    }

    @Test
    public void testTransfer() {
        Bank bank = new Bank();
        bank.createAccount("123", "John Doe", 100.0);
        bank.createAccount("456", "Jane Doe", 50.0);
        bank.transfer("123", "456", 30.0);
        assertEquals(70.0, bank.getAccount("123").getBalance(), 0.001);
        assertEquals(80.0, bank.getAccount("456").getBalance(), 0.001);
    }

}

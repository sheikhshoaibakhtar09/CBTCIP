package com.banky;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String accountNumber, String ownerName, double initialBalance) {
        Account account = new Account(accountNumber, ownerName, initialBalance);
        accounts.put(accountNumber, account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        }
    }

    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = getAccount(fromAccountNumber);
        Account toAccount = getAccount(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            return fromAccount.transfer(toAccount, amount);
        }
        return false;
    }

}

package com.banky;

import java.io.*;

public class BankFileOperations {
	private static final String FILE_NAME = "bank_data.txt";

    public static void saveBankData(Bank bank) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(bank);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Bank loadBankData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Bank) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Bank();
    }

}

package model.builder;

import model.CorporateBankAccount;
import model.CurrencyType;

import java.util.Random;

public class CorporateAccountBuilder extends BankAccountBuilder{
    private String accountType;
    private String accountNumber;
    private CurrencyType currencyType;
    private double balance;

    @Override
    public void buildAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public void buildAccountNumber() {
        int accountNumberLength = 10;
        StringBuilder accountNumber = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < accountNumberLength; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        this.accountNumber = 'C' + accountNumber.toString();
    }

    @Override
    public void buildCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    @Override
    public void buildBalance(int balance) {
        this.balance = balance;
    }

    public CorporateBankAccount build() {
        return new CorporateBankAccount(accountType, accountNumber, currencyType, balance);
    }

}
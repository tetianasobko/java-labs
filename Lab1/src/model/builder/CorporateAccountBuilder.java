package model.builder;

import model.BankAccount;
import model.CurrencyType;

import java.util.Objects;
import java.util.Random;

public class CorporateAccountBuilder extends BankAccountBuilder{
    private String companyName;

    public CorporateAccountBuilder(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void buildAccountType() {
        bankAccount.setAccountType("corporate: " + companyName);
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

        bankAccount.setAccountNumber('C' + accountNumber.toString());
    }

    @Override
    public void buildCurrencyType(CurrencyType currencyType) {
        bankAccount.setCurrencyType(currencyType);
    }

    @Override
    public void buildBalance() {
        bankAccount.setBalance(0);
    }

    @Override
    public BankAccount build() {
        return null;
    }

}
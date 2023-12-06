package org.example.model.builder;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.model.CorporateBankAccount;
import org.example.model.CurrencyType;
import org.example.model.IndividualBankAccount;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
        CorporateBankAccount account = new CorporateBankAccount(accountType, accountNumber, currencyType, balance);
        validate(account);
        return account;
    }

}
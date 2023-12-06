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

public class IndividualAccountBuilder extends BankAccountBuilder{
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

        this.accountNumber = 'I' + accountNumber.toString();
    }

    @Override
    public void buildCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    @Override
    public void buildBalance(int balance) {
        this.balance = balance;
    }

    private void validate(IndividualBankAccount account) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<String> validationMessages = new HashSet<>();
        Set<ConstraintViolation<IndividualBankAccount>> violations = validator.validate(account);

        for (ConstraintViolation<IndividualBankAccount> violation : violations) {
            validationMessages.add(violation.getInvalidValue() + ": " + violation.getMessage());
        }

        if (!validationMessages.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationMessages));
        }
    }

    public IndividualBankAccount build() {
        IndividualBankAccount account = new IndividualBankAccount(accountType, accountNumber, currencyType, balance);
        validate(account);
        return account;
    }
}

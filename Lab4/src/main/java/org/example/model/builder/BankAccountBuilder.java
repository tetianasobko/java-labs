package org.example.model.builder;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.model.BankAccount;
import org.example.model.CurrencyType;

import java.util.HashSet;
import java.util.Set;

public abstract class BankAccountBuilder<T> {
    public abstract T buildAccountType(String accountType);

    public abstract T buildAccountNumber();

    public abstract T buildCurrencyType(CurrencyType currencyType);

    public abstract T buildBalance(int balance);

    protected void validate(BankAccount account) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<String> validationMessages = new HashSet<>();
        Set<ConstraintViolation<BankAccount>> violations = validator.validate(account);

        for (ConstraintViolation<BankAccount> violation : violations) {
            validationMessages.add(violation.getInvalidValue() + ": " + violation.getMessage());
        }

        if (!validationMessages.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationMessages));
        }
    }
}

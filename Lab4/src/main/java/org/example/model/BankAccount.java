package org.example.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class BankAccount {
    protected String accountNumber;

    @NotNull(message = "Currency type must not be null")
    protected CurrencyType currencyType;

    @PositiveOrZero(message = "Balance must be zero or positive")
    protected Double balance;

}

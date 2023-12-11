package org.example.model;
import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class IndividualBankAccount extends BankAccount{
    @Pattern(regexp = "personal", message = "Account type must be 'personal'")
    private String accountType;

    private String accountNumber;

    @NotNull(message = "Currency type must not be null")
    private CurrencyType currencyType;

    @PositiveOrZero(message = "Balance must be zero or positive")
    private Double balance;

    public IndividualBankAccount(String accountType, String accountNumber, CurrencyType currencyType, double balance) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currencyType = currencyType;
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "IndividualBankAccount{" +
                "accountType='" + accountType + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", currencyType=" + currencyType +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndividualBankAccount that = (IndividualBankAccount) o;
        return Double.compare(balance, that.balance) == 0 && Objects.equals(accountType, that.accountType) && Objects.equals(accountNumber, that.accountNumber) && currencyType == that.currencyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, accountNumber, currencyType, balance);
    }
}

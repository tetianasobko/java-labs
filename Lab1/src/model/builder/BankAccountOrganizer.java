package model.builder;

import model.BankAccount;
import model.CurrencyType;

public class BankAccountOrganizer {
    private BankAccountBuilder bankAccountBuilder;

    public void setBankAccountBuilder(BankAccountBuilder bankAccountBuilder) {
        this.bankAccountBuilder = bankAccountBuilder;
    }

    public BankAccountBuilder getBankAccountBuilder() {
        return bankAccountBuilder;
    }

    public BankAccount getBankAccount() {
        return bankAccountBuilder.getBankAccount();
    }

    public void organizeBankAccount(CurrencyType currencyType) {
        bankAccountBuilder.createNewBankAccount();

        bankAccountBuilder.buildAccountType();
        bankAccountBuilder.buildAccountNumber();
        bankAccountBuilder.buildCurrencyType(currencyType);
        bankAccountBuilder.buildBalance();
    }
}

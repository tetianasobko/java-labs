package model.builder;

import model.CurrencyType;

public class BankAccountOrganizer {
    public void organizeIndividualAccount(BankAccountBuilder bankAccountBuilder) {
        bankAccountBuilder.buildAccountType("personal");
        bankAccountBuilder.buildAccountNumber();
        bankAccountBuilder.buildCurrencyType(CurrencyType.USD);
        bankAccountBuilder.buildBalance(0);
    }

    public void organizeCorporateAccount(BankAccountBuilder bankAccountBuilder) {
        bankAccountBuilder.buildAccountType("corporate");
        bankAccountBuilder.buildAccountNumber();
        bankAccountBuilder.buildCurrencyType(CurrencyType.EUR);
        bankAccountBuilder.buildBalance(0);
    }

    public void organizeCreditAccount(BankAccountBuilder bankAccountBuilder) {
        bankAccountBuilder.buildAccountType("personal");
        bankAccountBuilder.buildAccountNumber();
        bankAccountBuilder.buildCurrencyType(CurrencyType.UAH);
        bankAccountBuilder.buildBalance(11000);
    }
}

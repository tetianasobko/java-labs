package model.builder;
import model.IndividualBankAccount;
import model.CurrencyType;

public abstract class BankAccountBuilder {
    public abstract void buildAccountType(String accountType);
    public abstract void buildAccountNumber();
    public abstract void buildCurrencyType(CurrencyType currencyType);
    public abstract void buildBalance(int balance);

}

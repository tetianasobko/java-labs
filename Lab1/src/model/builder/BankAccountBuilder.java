package model.builder;
import model.BankAccount;
import model.CurrencyType;
import java.util.Objects;

public abstract class BankAccountBuilder {
    protected BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void createNewBankAccount() {
        bankAccount = new BankAccount();
    }

    public abstract void buildAccountType();
    public abstract void buildAccountNumber();
    public abstract void buildCurrencyType(CurrencyType currencyType);
    public abstract void buildBalance();

    public abstract BankAccount build();
}

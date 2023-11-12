import java.util.Objects;

public abstract class BankAccountBuilder {
    protected BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void createNewBankAccount() {
        bankAccount = new BankAccount();
    }

    public abstract void buildOwnerName();
    public abstract void buildAccountNumber();
    public abstract void buildCurrencyType(CurrencyType currencyType);
    public abstract void buildBalance();

    @Override
    public String toString() {
        return "BankAccountBuilder:" +
                "bankAccount=" + bankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountBuilder that = (BankAccountBuilder) o;
        return Objects.equals(bankAccount, that.bankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccount);
    }
}

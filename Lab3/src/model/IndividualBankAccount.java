package model;
import java.util.Objects;

public class IndividualBankAccount extends BankAccount{
    public IndividualBankAccount(String accountType, String accountNumber, CurrencyType currencyType, double balance) {
        super(accountType, accountNumber, currencyType, balance);
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

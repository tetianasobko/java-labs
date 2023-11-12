import java.util.Objects;
import java.util.Random;

public class CorporateAccountBuilder extends BankAccountBuilder{
    private String companyName;

    public CorporateAccountBuilder(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void buildOwnerName() {
        bankAccount.setOwnerName(companyName);
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

        bankAccount.setAccountNumber('C' + accountNumber.toString());
    }

    @Override
    public void buildCurrencyType(CurrencyType currencyType) {
        bankAccount.setCurrencyType(currencyType);
    }

    @Override
    public void buildBalance() {
        bankAccount.setBalance(0);
    }

    @Override
    public String toString() {
        return "CorporateAccountBuilder{" +
                "companyName='" + companyName + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CorporateAccountBuilder that = (CorporateAccountBuilder) o;
        return Objects.equals(companyName, that.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), companyName);
    }
}
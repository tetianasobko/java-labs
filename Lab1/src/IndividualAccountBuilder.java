import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class IndividualAccountBuilder extends BankAccountBuilder{
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate dateOfBirth;

    public IndividualAccountBuilder(String firstName, String lastName, String patronymic, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void buildOwnerName() {
        bankAccount.setOwnerName(firstName + " " + lastName + " " + patronymic);
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

        bankAccount.setAccountNumber('I' + accountNumber.toString());
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
        return "IndividualAccountBuilder{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", bankAccount=" + bankAccount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IndividualAccountBuilder that = (IndividualAccountBuilder) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(patronymic, that.patronymic) && Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, patronymic, dateOfBirth);
    }
}

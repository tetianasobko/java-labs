import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankAccountOrganizer organizer = new BankAccountOrganizer();
        BankAccountBuilder individual = new IndividualAccountBuilder("Tetiana", "Sobko", "Viktorivna",
                LocalDate.of(2004, 1, 22));
        BankAccountBuilder corporate = new CorporateAccountBuilder("SoftServe");

        organizer.setBankAccountBuilder(individual);
        organizer.organizeBankAccount(CurrencyType.EUR);

        organizer.setBankAccountBuilder(corporate);
        organizer.organizeBankAccount(CurrencyType.USD);
    }
}
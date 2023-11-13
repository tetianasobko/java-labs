import model.BankAccount;
import model.CurrencyType;
import model.builder.BankAccountBuilder;
import model.builder.BankAccountOrganizer;
import model.builder.CorporateAccountBuilder;
import model.builder.IndividualAccountBuilder;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankAccountOrganizer organizer = new BankAccountOrganizer();
        BankAccountBuilder individual = new IndividualAccountBuilder("Tetiana", "Sobko", "Viktorivna");
        BankAccountBuilder corporate = new CorporateAccountBuilder("SoftServe");

        organizer.setBankAccountBuilder(individual);
        organizer.organizeBankAccount(CurrencyType.EUR);

        organizer.setBankAccountBuilder(corporate);
        organizer.organizeBankAccount(CurrencyType.USD);

        BankAccount account = organizer.getBankAccount();
//
//        BankAccount account1 =
    }
}
import model.BankAccount;
import model.Client;
import model.CorporateBankAccount;
import model.IndividualBankAccount;
import model.builder.BankAccountOrganizer;
import model.builder.CorporateAccountBuilder;
import model.builder.IndividualAccountBuilder;
import services.BankAccountServiceComp;
import services.BankAccountServiceStream;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Client client = initializeClient();

//        BankAccountServiceComp serviceComp = new BankAccountServiceComp(client.getAccounts());
//        output(serviceComp.sortByAccountBalance());
//        System.out.println();
//        output(serviceComp.sortByAccountNumber());
//        System.out.println();
//        output(serviceComp.filterByAccountType("pers"));
//        System.out.println();
//        output(serviceComp.filterByCurrencyType("US"));

        BankAccountServiceStream serviceStream = new BankAccountServiceStream(client.getAccounts());
        output(serviceStream.sortByAccountBalance());
        System.out.println();
        output(serviceStream.sortByAccountNumber());
        System.out.println();
        output(serviceStream.filterByAccountType("pers"));
        System.out.println();
        output(serviceStream.filterByCurrencyType("US"));

    }

    public static Client initializeClient() {
        BankAccountOrganizer organizer = new BankAccountOrganizer();

        IndividualAccountBuilder individualBuilder = new IndividualAccountBuilder();
        organizer.organizeIndividualAccount(individualBuilder);
        IndividualBankAccount individualBankAccount = individualBuilder.build();

        CorporateAccountBuilder corporateBuilder = new CorporateAccountBuilder();
        organizer.organizeCorporateAccount(corporateBuilder);
        CorporateBankAccount corporateBankAccount = corporateBuilder.build();

        organizer.organizeCreditAccount(individualBuilder);
        IndividualBankAccount creditBankAccount = individualBuilder.build();

        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(individualBankAccount);
        bankAccountList.add(corporateBankAccount);
        bankAccountList.add(creditBankAccount);

        return new Client("Tetiana", "Sobko", "Viktorivna", LocalDate.of(2004, 01, 22), "12345", bankAccountList);
    }

    public static void output(List<BankAccount> bankAccountList) {
        for (BankAccount bankAccount : bankAccountList) {
            System.out.println(bankAccount);
        }
    }
}
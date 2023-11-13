import model.CorporateBankAccount;
import model.IndividualBankAccount;
import model.CurrencyType;
import model.builder.BankAccountBuilder;
import model.builder.BankAccountOrganizer;
import model.builder.CorporateAccountBuilder;
import model.builder.IndividualAccountBuilder;

public class Main {
    public static void main(String[] args) {
        BankAccountOrganizer organizer = new BankAccountOrganizer();

        IndividualAccountBuilder individualBuilder = new IndividualAccountBuilder();
        organizer.organizeIndividualAccount(individualBuilder);

        IndividualBankAccount individualBankAccount = individualBuilder.build();
        System.out.println("Individual account: " + individualBankAccount.getAccountType());

        CorporateAccountBuilder corporateBuilder = new CorporateAccountBuilder();
        organizer.organizeCorporateAccount(corporateBuilder);

        CorporateBankAccount corporateBankAccount = corporateBuilder.build();
        System.out.println("Corporate account: " + corporateBankAccount.getAccountType());
    }
}
import model.CorporateBankAccount;
import model.IndividualBankAccount;
import model.CurrencyType;
import model.builder.BankAccountBuilder;
import model.builder.BankAccountOrganizer;
import model.builder.IndividualAccountBuilder;
import org.example.services.JsonSerializer;
import org.example.services.TxtSerializer;
import org.example.services.XmlSerializer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BankAccountOrganizer organizer = new BankAccountOrganizer();

        IndividualAccountBuilder individualBuilder = new IndividualAccountBuilder();
        organizer.organizeIndividualAccount(individualBuilder);

        IndividualBankAccount individualBankAccount = individualBuilder.build();
        System.out.println("Individual account: " + individualBankAccount.getAccountType());

        JsonSerializer<IndividualBankAccount> jsonSerializer = new JsonSerializer<>();
        jsonSerializer.serialize(individualBankAccount, "lab2_jsonOutput.json");
        System.out.println("Json: " + jsonSerializer.deserialize("lab2_jsonOutput.json", IndividualBankAccount.class));

        XmlSerializer<IndividualBankAccount> xmlSerializer = new XmlSerializer<>();
        xmlSerializer.serialize(individualBankAccount, "lab2_xmlOutput.xml");
        System.out.println("Xml: " + xmlSerializer.deserialize("lab2_xmlOutput.xml", IndividualBankAccount.class));

        TxtSerializer<IndividualBankAccount> txtSerializer = new TxtSerializer<>();
        txtSerializer.serialize(individualBankAccount, "lab2_txtOutput.txt");
        System.out.println("Txt: " + txtSerializer.deserialize("lab2_txtOutput.txt", IndividualBankAccount.class));

    }
}
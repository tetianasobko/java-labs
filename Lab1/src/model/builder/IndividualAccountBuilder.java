package model.builder;

import model.BankAccount;
import model.CurrencyType;
import java.util.Random;

public class IndividualAccountBuilder extends BankAccountBuilder{
    private String firstName;
    private String lastName;
    private String patronymic;

    public IndividualAccountBuilder(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }


    public IndividualAccountBuilder() {
    }

    @Override
    public void buildAccountType() {
        bankAccount.setAccountType("personal: " + firstName + " " + lastName + " " + patronymic);
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
    public BankAccount build() {
        return null;
    }


}

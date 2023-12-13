package org.example;

import org.example.model.CorporateBankAccount;
import org.example.model.IndividualBankAccount;
import org.example.model.builder.BankAccountOrganizer;
import org.example.model.builder.CorporateAccountBuilder;
import org.example.model.builder.IndividualAccountBuilder;

public class Main {
    public static void main(String[] args) {
        BankAccountOrganizer organizer = new BankAccountOrganizer();

        IndividualAccountBuilder individualBuilder = new IndividualAccountBuilder();
        organizer.organizeIndividualAccount(individualBuilder);

        IndividualBankAccount individualBankAccount = individualBuilder.build();
        System.out.println("Individual account: " + individualBankAccount.getAccountNumber());

        IndividualBankAccount invalidBankAccount = new IndividualAccountBuilder()
                .buildAccountType("individual")
                .buildAccountNumber()
                .buildBalance(-100)
                .build();
    }
}
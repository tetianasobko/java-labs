package org.example;

public class Main {
    public static void main(String[] args) {
        String URL = "jdbc:sqlite:data.db";
        DataBaseManager dbManager = new DataBaseManager(URL);
        ClientDB clientDB = new ClientDB(dbManager);
        BankAccountDB bankAccountDB = new BankAccountDB(dbManager);

//        clientDB.createClientTable();
//        bankAccountDB.createBankAccountTable();
        bankAccountDB.dropBankAccountTable();
        clientDB.dropClientTable();




        dbManager.close();
    }
}
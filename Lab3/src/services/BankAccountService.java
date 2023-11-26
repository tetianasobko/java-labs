package services;

import model.BankAccount;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> sortByAccountBalance();
    List<BankAccount> sortByAccountNumber();
    List<BankAccount> filterByAccountType(String type);
    List<BankAccount> filterByCurrencyType(String currencyType);


}

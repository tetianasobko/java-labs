package services;

import model.BankAccount;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankAccountServiceStream implements BankAccountService{
    private final List<BankAccount> bankAccountList;

    public BankAccountServiceStream(List<BankAccount> bankAccountList) {

        this.bankAccountList = bankAccountList;
    }

    @Override
    public List<BankAccount> sortByAccountBalance() {
        return bankAccountList.stream()
                .sorted(Comparator.comparing(BankAccount::getBalance))
                .collect(Collectors.toList());
    }

    @Override
    public List<BankAccount> sortByAccountNumber() {
        return bankAccountList.stream()
                .sorted(Comparator.comparing(BankAccount::getAccountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public List<BankAccount> filterByAccountType(String type) {
        return bankAccountList.stream()
                .filter(bankAccount -> bankAccount.getAccountType().contains(type))
                .collect(Collectors.toList());
    }


    @Override
    public List<BankAccount> filterByCurrencyType(String currencyType) {
        return bankAccountList.stream()
                .filter(bankAccount -> bankAccount.getCurrencyType().toString().contains(currencyType))
                .collect(Collectors.toList());
    }
}

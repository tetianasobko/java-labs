package services;

import model.BankAccount;

import java.util.*;

public class BankAccountServiceComp implements BankAccountService{

    private final List<BankAccount> bankAccountList;

    public BankAccountServiceComp(List<BankAccount> bankAccountList) {

        this.bankAccountList = bankAccountList;
    }

    @Override
    public List<BankAccount> sortByAccountBalance() {
        List<BankAccount> result = new ArrayList<>(bankAccountList);
        result.sort(Comparator.comparing(BankAccount::getBalance));
        return result;
    }

    @Override
    public List<BankAccount> sortByAccountNumber() {
        List<BankAccount> result = new ArrayList<>(bankAccountList);
        Collections.sort(result);
        return result;
    }

    @Override
    public List<BankAccount> filterByAccountType(String type) {
        List<BankAccount> result = new ArrayList<>();
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getAccountType().contains(type)) {
                result.add(bankAccount);
            }
        }
        return result;
    }

    @Override
    public List<BankAccount> filterByCurrencyType(String currencyType) {
        List<BankAccount> result = new ArrayList<>();
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getCurrencyType().toString().contains(currencyType)) {
                result.add(bankAccount);
            }
        }
        return result;
    }
}

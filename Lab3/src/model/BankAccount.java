package model;

public class BankAccount implements Comparable<BankAccount>{
    protected String accountType;
    protected String accountNumber;
    protected CurrencyType currencyType;
    protected double balance;

    public BankAccount(String accountType, String accountNumber, CurrencyType currencyType, double balance) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currencyType = currencyType;
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int compareTo(BankAccount o) {
        return this.accountNumber.compareTo(o.accountNumber);
    }
}

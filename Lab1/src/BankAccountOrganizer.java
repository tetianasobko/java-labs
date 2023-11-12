public class BankAccountOrganizer {
    private BankAccountBuilder bankAccountBuilder;

    public void setBankAccountBuilder(BankAccountBuilder bankAccountBuilder) {
        this.bankAccountBuilder = bankAccountBuilder;
    }

    public BankAccountBuilder getBankAccountBuilder() {
        return bankAccountBuilder;
    }

    public BankAccount getBankAccount() {
        return bankAccountBuilder.getBankAccount();
    }

    /**
     * Method to organize a competition on specified date
     */
    public void organizeBankAccount(CurrencyType currencyType) {
        bankAccountBuilder.createNewBankAccount();

        bankAccountBuilder.buildOwnerName();
        bankAccountBuilder.buildAccountNumber();
        bankAccountBuilder.buildCurrencyType(currencyType);
        bankAccountBuilder.buildBalance();
    }
}

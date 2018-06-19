package account;

import account.impl.CreditCardAccount;
import account.impl.CurrentAccount;
import account.impl.SavingsAccount;

public class AccountFactory {
    protected Bank bank;

    public AccountFactory(Bank bank){
        this.bank = bank;
    }

    /*To implement factory pattern without exposing the creation logic to the client
    * useing common interface*/
    public Account createAccount(AccountType accountType, double balance, boolean improvedSoluton) {
        if (accountType == null) {
            throw new RuntimeException(("account type can not be null"));
        }
        if(improvedSoluton)
            return createAccountImprovedSolution(accountType, balance);
        else return createAccountBasicSolution(accountType, balance);
    }

    public Account createAccountBasicSolution(AccountType accountType, double balance){
        switch (accountType){
            case SAVING:
                return new SavingsAccount(bank, balance);
            case CURRENT:
                return new CurrentAccount(bank, balance);
            case CREDITCARD:
                return new CreditCardAccount(bank, balance);
            default:
                return null;
        }
    }

    public Account createAccountImprovedSolution(AccountType accountType, double balance) {
        return accountType.getInstance(bank, balance);
    }
}

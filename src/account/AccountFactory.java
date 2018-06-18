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
    public Account createAccount(AccountType accountType, double balance) {
        if (accountType == null) {
            return null;
        }
        switch (accountType) {
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
}

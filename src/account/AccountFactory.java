package account;

import account.impl.CreditCardAccount;
import account.impl.CurrentAccount;
import account.impl.SavingsAccount;

public class AccountFactory {
    protected Bank bank;

    public AccountFactory(Bank bank){
        this.bank = bank;
    }

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

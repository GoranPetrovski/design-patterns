package account;

import account.impl.CreditCardAccount;
import account.impl.CurrentAccount;
import account.impl.SavingsAccount;

public class AccountFactory {

    public Account createAccount(AccountType accountType, double balance) {
        if (accountType == null) {
            return null;
        }

        switch (accountType) {
            case SAVING:
                return new SavingsAccount(balance);
            case CURRENT:
                return new CurrentAccount(balance);
            case CREDITCARD:
                return new CreditCardAccount(balance);
            default:
                return null;
        }
    }
}

package account;

import account.impl.CreditCardAccount;
import account.impl.CurrentAccount;
import account.impl.SavingsAccount;

public enum AccountType {
    CREDITCARD {
        @Override
        Account getInstance(Bank bank, double balance) {
            return new CreditCardAccount(bank, balance);
        }
    }, SAVING {
        @Override
        Account getInstance(Bank bank, double balance) {
            return new SavingsAccount(bank, balance);
        }
    }, CURRENT {
        @Override
        Account getInstance(Bank bank, double balance) {
            return new CurrentAccount(bank, balance);
        }
    };

    abstract Account getInstance(Bank bank, double balance);
}

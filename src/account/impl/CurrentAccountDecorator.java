package account.impl;

import account.Account;
import account.AccountDecorator;

public class CurrentAccountDecorator extends AccountDecorator {
    public CurrentAccountDecorator(Account decoratedAccount) {
        super(decoratedAccount);
    }

    @Override
    public double depositingMoney(double amount) {
        return 0;
    }

    @Override
    public double withdrawingMoney(double amount) {
        return 0;
    }
}

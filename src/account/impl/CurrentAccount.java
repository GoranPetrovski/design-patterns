package account.impl;

import account.Account;
import account.AccountHelper;
import account.BasicInfoAccount;

public class CurrentAccount extends BasicInfoAccount implements Account {
    public static final double CURRENT_ACCOUNT_TAX = 25;
    AccountHelper accountHelper = new AccountHelper();

    public CurrentAccount(double balance){
        setBalance(balance);
    }

    @Override
    public double depositingMoney(double amount) {
        setBalance(getBalance()+ amount - CURRENT_ACCOUNT_TAX);
        return getBalance();
    }

    @Override
    public double withdrawingMoney(double amount) {
        Double total = accountHelper.withdrawingMoney(getBalance(), amount, CURRENT_ACCOUNT_TAX);
        setBalance(getBalance() - amount);
        return getBalance();
    }

    @Override
    public double checkBalance() {
        return getBalance();
    }
}

package account.impl;

import account.Account;
import account.AccountHelper;
import account.BasicInfoAccount;

public class SavingsAccount extends BasicInfoAccount implements Account {
    AccountHelper accountHelper = new AccountHelper();
    public SavingsAccount(double balance){
        setBalance(balance);
    }

    @Override
    public double depositingMoney(double amount) {
        setBalance(getBalance()+ amount);
        return getBalance();
    }

    @Override
    public double withdrawingMoney(double amount) {
        accountHelper.withdrawingMoney(getBalance(), amount, 0);
        setBalance(getBalance() - amount);
        return getBalance();
    }

    @Override
    public double checkBalance() {
        return getBalance();
    }
}

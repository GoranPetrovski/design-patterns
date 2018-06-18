package account.impl;

import account.Account;
import account.AccountHelper;
import account.Bank;

public class CurrentAccount extends  Account {
    public static final double CURRENT_ACCOUNT_TAX = 25;
    AccountHelper accountHelper;

    public CurrentAccount(Bank bank, double balance){
        accountHelper = new AccountHelper();
        this.bank = bank;
        this.bank.attach(this);
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

    @Override
    public void update() {
        System.out.println("Balance of current amount was updated! and current value of balance is"+ getBalance());
    }
}

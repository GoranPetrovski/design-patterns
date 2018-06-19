package account.impl;

import account.Account;
import account.AccountHelper;
import account.Bank;

/*
concreate class implementation for Account
I am added different taxes for every class implementation
 for reason to have different Account class implememntation
* */
public class CurrentAccount extends  Account {
    public static final double CURRENT_ACCOUNT_TAX = 25;
    AccountHelper accountHelper;

    public CurrentAccount(Bank bank, double balance){
        accountHelper = new AccountHelper();
        this.bank = bank;
        this.bank.registerObserver(this);
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

    /*This method is added to have Observer pattern */
    @Override
    public void inform() {
        System.out.println("Balance of current amount was updated! and current value of balance is"+ getBalance());
    }
}

package account.impl;

import account.Account;
import account.AccountHelper;
import account.Bank;

public class SavingsAccount extends  Account {
    protected  AccountHelper accountHelper;

    public SavingsAccount(Bank bank, double balance){
        accountHelper = new AccountHelper();
        this.bank = bank;
        this.bank.registerObserver(this);
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

    @Override
    public void inform() {
        System.out.println("Balance of saving amount was updated! and current value of balance is"+ getBalance());
    }
}

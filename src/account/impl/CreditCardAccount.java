package account.impl;

import account.Account;
import account.AccountHelper;
import account.Bank;

/*
concreate class implementation for Account
* */
public class CreditCardAccount extends Account {

    public static final double CREDIT_CARD_TAX = 15;
    AccountHelper accountHelper;

    public CreditCardAccount(Bank bank, double balance){
        accountHelper = new AccountHelper();
        this.bank = bank;
        this.bank.attach(this);
        this.setBalance(balance);
    }

    @Override
    public double depositingMoney(double amount) {
        setBalance(getBalance()+ amount - CREDIT_CARD_TAX);
        return getBalance();
    }

    @Override
    public double withdrawingMoney(double amount) {
        Double total = accountHelper.withdrawingMoney(getBalance(), amount, CREDIT_CARD_TAX);
        setBalance(total);
        return getBalance();
    }

    @Override
    public double checkBalance() {
        return getBalance();
    }

    @Override
    public void update() {
        System.out.println("Balance of creadit card amount was updated! and current value of balance is: "+ getBalance());
    }
}

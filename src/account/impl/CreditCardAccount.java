package account.impl;

import account.Account;
import account.AccountHelper;
import account.BasicInfoAccount;

public class CreditCardAccount extends BasicInfoAccount implements Account {

    public static final double CREDIT_CARD_TAX = 15;
    AccountHelper accountHelper = new AccountHelper();

    public CreditCardAccount(double balance){
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
}

package account.impl;

import account.Account;
import account.AccountDecorator;
import account.AccountHelper;


public class CreditCardDecorator extends AccountDecorator {

    AccountHelper accountHelper = new AccountHelper();
    public CreditCardDecorator(Account decoratedAccount) {
        super(decoratedAccount);
    }

    @Override
    public double depositingMoney(double amount) {
        setAdditionalProperty();
        setBalance(getBalance()+ amount - setAdditionalProperty());
        return getBalance();
    }

    @Override
    public double withdrawingMoney(double amount) {
        Double total = accountHelper.withdrawingMoney(getBalance(), amount, setAdditionalProperty());
        setBalance(total);
        return getBalance();
    }

    @Override
    public void update() {

    }

    /*additional functionality*/
    int  setAdditionalProperty(){
        return 20;
    }
}

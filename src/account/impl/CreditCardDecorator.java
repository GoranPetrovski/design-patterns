package account.impl;

import account.Account;
import account.AccountDecorator;
import account.AccountHelper;

/*
implement decorator pattern and add additional tax for each bank transacion
* */
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

    /*additional functionality*/
    int  setAdditionalProperty(){
        return 20;
    }

    @Override
    public void inform() {

    }
}

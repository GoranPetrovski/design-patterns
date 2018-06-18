package test;

import account.Account;
import account.AccountFactory;
import account.AccountType;
import account.Bank;
import org.junit.Assert;
import org.junit.Test;

public class DesignPatternsTest {

    Bank bank = new Bank();
    AccountFactory accountFactory = new AccountFactory(bank);

    @Test(expected = RuntimeException.class)
    public final void whenWithdrawMoneyFromLowerBalanceThenExceptionIsThrown(){
        Account accountCreditCard = accountFactory.createAccount(AccountType.CREDITCARD, 2000);
        accountCreditCard.withdrawingMoney(5000);
    }

    @Test
    public final void whenCheckBalanceThenValidateBalance(){
        Account accountCreditCard = accountFactory.createAccount(AccountType.CREDITCARD, 2000);
        Assert.assertEquals(2000.0, accountCreditCard.checkBalance(), 0.0);
    }

    @Test
    public final void whenDepositingMoneyThen (){
        Account accountCreditCard = accountFactory.createAccount(AccountType.CREDITCARD, 9000);
        accountCreditCard.withdrawingMoney(500);
        /* 15 is value of tax for this type of transacion
        * */
        Assert.assertEquals(9000.0 - 500 -15, accountCreditCard.checkBalance(), 0.0);
    }
}

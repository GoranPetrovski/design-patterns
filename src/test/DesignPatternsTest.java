package test;

import account.Account;
import account.AccountFactory;
import account.AccountType;
import org.junit.Assert;
import org.junit.Test;

public class DesignPatternsTest {

    AccountFactory accountFactory = new AccountFactory();

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
}

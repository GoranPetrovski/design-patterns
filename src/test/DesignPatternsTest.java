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
    public static final double CREDIT_CARD_TAX = 15;
    public static final double CURRENT_ACCOUNT_TAX = 25;

    @Test(expected = RuntimeException.class)
    public final void whenWithdrawMoneyFromLowerBalanceThenExceptionIsThrown(){
        Account accountCreditCard = accountFactory.createAccount(AccountType.CREDITCARD, 2000, true);
        accountCreditCard.withdrawingMoney(5000);
    }

    @Test
    public final void whenCheckBalanceThenValidateBalance(){
        Account accountCreditCard = accountFactory.createAccount(AccountType.CREDITCARD, 2000, true);
        Assert.assertEquals(2000.0, accountCreditCard.checkBalance(), 0.0);
    }

    @Test
    public final void whenDepositingMoneyThenReturnCorrectBalance (){
        Account accountCreditCard = accountFactory.createAccount(AccountType.CREDITCARD, 9000, true);
        accountCreditCard.depositingMoney(500);
        /* 15 is value of tax for this type of transacion
        * */
        Assert.assertEquals(9000.0 + 500 - CREDIT_CARD_TAX, accountCreditCard.checkBalance(), 0.0);
    }

    @Test
    public final void whenWithdrawMoneyThenReturnCorrectBalance (){
        Account accountCreditCard = accountFactory.createAccount(AccountType.CREDITCARD, 9000, true);
        accountCreditCard.withdrawingMoney(500);
        /* 15 is value of tax for this type of transacion
         * */
        Assert.assertEquals(9000.0 - 500 - CREDIT_CARD_TAX, accountCreditCard.checkBalance(), 0.0);
    }

    @Test
    public final void whenDepositingMoneyFromCurrentAccountThenReturnCorrectBalance (){
        Account accountCreditCard = accountFactory.createAccount(AccountType.CURRENT, 9000, true);
        accountCreditCard.depositingMoney(500);
        /* 25 is value of tax for this type of transacion
         * */
        Assert.assertEquals(9000.0 + 500 - CURRENT_ACCOUNT_TAX, accountCreditCard.checkBalance(), 0.0);
    }

    @Test
    public final void whenWithdrawMoneyFromCurrentAccountThenReturnCorrectBalance (){
        Account accountCreditCard = accountFactory.createAccount(AccountType.CURRENT, 9000, true);
        accountCreditCard.withdrawingMoney(500);
        /* 25 is value of tax for this type of transacion
         * */
        Assert.assertEquals(9000.0 - 500 - CURRENT_ACCOUNT_TAX, accountCreditCard.checkBalance(), 0.0);
    }
}

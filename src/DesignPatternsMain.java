import account.Account;
import account.AccountFactory;
import account.AccountType;
import account.Bank;
import account.impl.CreditCardAccount;
import account.impl.CreditCardDecorator;
import account.impl.CurrentAccount;
import account.impl.SavingsAccount;

public class DesignPatternsMain {

    public static void main(String[] args){

        /* I am implemented 3 design patterns:
        Observer
        Factory
        Decorator

        Observer design pattern. In this case
            Bank class represents Subject
            Account class represent Observer
        * */


        // create subject
        Bank bank = new Bank();

        /*Factory pattern*/
        AccountFactory accountFactory = new AccountFactory(bank);

        Account accountCreditCart = bank.openBankAccount(AccountType.CREDITCARD, 3500);
        Account accountSaving = bank.openBankAccount(AccountType.SAVING, 5000);
        Account accountCurrent = bank.openBankAccount(AccountType.CURRENT, 7000);

        bank.depositingMoney(accountCreditCart, 500);
        bank.withdrawingMoney(accountCurrent, 1200);
        bank.withdrawingMoney(accountSaving, 100);

        /*
        decorator pattern (add new functionality to an existing object)
        * */
        Account account5 = new CreditCardDecorator(new CreditCardAccount(bank, 8000));
        System.out.println(account5.getBalance());
    }
}

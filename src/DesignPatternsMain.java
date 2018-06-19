import account.*;
import account.impl.CreditCardAccount;
import account.impl.CreditCardDecorator;

public class DesignPatternsMain {

    public static void main(String[] args){

        /* I am implemented 3 design patterns:
        Observer
        Factory
        Decorator
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

        /* using lambda expression */
        System.out.println(" == observable pattern in combination with lambda expression ==");
        AccountHelper accountHelper = new AccountHelper();
        bank.registerObserver((accountType) -> {
            if(accountHelper.isCreditCardAccount(accountType))
                System.out.println("Inform update credit card account");
        });
        bank.registerObserver((accountType) -> {
            if(accountHelper.isSavingAccount(accountType))
                 System.out.println("Inform update saving account");
        });
        bank.registerObserver((accountType) -> {
            if(accountHelper.isCurrent(accountType))
                System.out.println("Inform update current account");
        });
        bank.notifyObservers(AccountType.SAVING);
    }
}

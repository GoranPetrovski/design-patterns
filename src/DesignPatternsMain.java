import account.Account;
import account.AccountFactory;
import account.AccountType;

public class DesignPatternsMain {

    public static void main(String[] args){

        Bank bank = new Bank();
       /* account factory pattern
        example implementation
        * */
        AccountFactory accountFactory = new AccountFactory();
        Account accountCreditCart = accountFactory.createAccount(AccountType.CREDITCARD, 3500);
        bank.openBankAccount(accountCreditCart);

        Account accountSaving = accountFactory.createAccount(AccountType.SAVING, 4000);
        bank.openBankAccount(accountCreditCart);

        Account accountCurrent = accountFactory.createAccount(AccountType.CURRENT, 7000);
        bank.openBankAccount(accountCreditCart);

        System.out.println("Check Balance");
        System.out.println(accountCreditCart.checkBalance());
        System.out.println(accountSaving.checkBalance());
        System.out.println(accountCurrent.checkBalance());

        accountCreditCart.depositingMoney(2000);
        System.out.println(accountCreditCart.checkBalance());
        accountCreditCart.withdrawingMoney(1000);
        System.out.println(accountCreditCart.checkBalance());
    }
}

package account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }

    public Account openBankAccount(AccountType accountType, double balance){
        AccountFactory accountFactory = new AccountFactory(this);
        Account account = accountFactory.createAccount(accountType, balance);
        return account;
    }


    public double depositingMoney(Account account, double amount){
        System.out.println("Bank deposit money === ");
        notifyAllObservers();
        return account.depositingMoney(amount);
    }

    public double  withdrawingMoney(Account account, double amount){
        notifyAllObservers();
        return account.withdrawingMoney(amount);
    }

    /*Observer pattern*/
    public void attach(Account observer){
        accounts.add(observer);
    }

    /*Observer pattern
    * to notify all observers (accounts)
    * */
    public void notifyAllObservers(){
        System.out.println("Size accounts = "+ accounts.size());
        for (Account observer : accounts) {
            System.out.println("Account = "+observer.getBalance());
            observer.update();
        }
    }

    double checkingBalance(Account account){
        return account.checkBalance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}

package account;

import java.util.ArrayList;
import java.util.List;

/*Bank class represents Subject
  in Observable design pattern
* */
public class Bank implements Subject{
    private String name;

    //list of observers
    private final List<Observer> accounts = new ArrayList<>();

    public Account openBankAccount(AccountType accountType, double balance){
        AccountFactory accountFactory = new AccountFactory(this);
        Account account = accountFactory.createAccount(accountType, balance, true);
        return account;
    }

    public double depositingMoney(Account account, double amount){
        System.out.println("Deposit money from account: "+amount);
        notifyObservers(AccountType.CREDITCARD);
        return account.depositingMoney(amount);
    }

    public double  withdrawingMoney(Account account, double amount){
        notifyObservers(AccountType.CREDITCARD);
        return account.withdrawingMoney(amount);
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
    public void registerObserver(Observer observer) {
        this.accounts.add(observer);
    }

    /*Observer pattern
     * to notify all observers (accounts) using lambda expression
     * */
    @Override
    public void notifyObservers(AccountType accountType) {
        System.out.println("Notify observers (accounts) with size: "+ accounts.size());
        accounts.forEach(o -> o.inform(accountType));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}

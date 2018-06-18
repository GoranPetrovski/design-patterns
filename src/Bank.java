import account.Account;
import account.AccountFactory;
import account.AccountType;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }

    Account openBankAccount(AccountType accountType, double balance){
        AccountFactory accountFactory = new AccountFactory();
        Account account = accountFactory.createAccount(accountType, balance);
        accounts.add(account);
        return account;
    }

    Account openBankAccount(Account account){
        accounts.add(account);
        return account;
    }

    double depositingMoney(Account account, double amount){
        return account.depositingMoney(amount);
    }

    double  withdrawingMoney(Account account, double amount){
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
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}

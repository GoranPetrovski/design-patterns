package account;

/*To prevent repititive code through the implementation of Account class methods I am created this AccountHelper class*/
public class AccountHelper {
    public double withdrawingMoney(double balance, double amount, double tax) {
        Double total = balance - amount - tax;
        if(total < 0){
            throw new RuntimeException(("You can not withdraw money!"));
        }
        return total;
    }

    public boolean isCreditCardAccount(AccountType accountType){
        return accountType == AccountType.CREDITCARD;
    }

    public boolean isSavingAccount(AccountType accountType){
        return accountType == AccountType.SAVING;
    }

    public boolean isCurrent(AccountType accountType){
        return accountType == AccountType.CURRENT;
    }
}

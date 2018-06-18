package account;

/*Decorator pattern*/
public abstract class AccountDecorator extends Account{
    protected Account decoratedAccount;

    public AccountDecorator(Account decoratedAccount){
        this.decoratedAccount = decoratedAccount;
    }

    public double checkBalance(){
        return decoratedAccount.checkBalance();
    }
}

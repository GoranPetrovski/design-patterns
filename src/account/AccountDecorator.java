package account;

public abstract class AccountDecorator implements Account{
    protected Account decoratedAccount;

    public AccountDecorator(Account decoratedAccount){
        this.decoratedAccount = decoratedAccount;
    }

    public double checkBalance(){
        return decoratedAccount.checkBalance();
    }
}

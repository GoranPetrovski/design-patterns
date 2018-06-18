package account;

/*
I know that Account can be interface or class, because I like to implement Observer pattern
and I must to have proerties like Bank .. I decide to go with class in this case
* */
public abstract class Account {
    private String ownerIdentification;
    private double balance;
    protected Bank bank;

    public abstract double depositingMoney(double amount);
    public abstract double withdrawingMoney(double amount);
    public abstract double checkBalance();
    public abstract void update();

    public String getOwnerIdentification() {
        return ownerIdentification;
    }

    public void setOwnerIdentification(String ownerIdentification) {
        this.ownerIdentification = ownerIdentification;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

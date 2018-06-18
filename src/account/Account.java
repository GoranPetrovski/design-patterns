package account;

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

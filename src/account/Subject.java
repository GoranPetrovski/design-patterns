package account;

public interface Subject {
    void registerObserver(Observer observer);
    void notifyObservers(AccountType accountType);
}

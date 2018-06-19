package account;

public interface Subject {
    void registerObserver(Account observer);
    void notifyObservers();
}

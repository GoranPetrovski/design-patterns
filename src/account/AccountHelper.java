package account;

public class AccountHelper {
    public double withdrawingMoney(double balance, double amount, double tax) {
        Double total = balance - amount - tax;
        if(total < 0){
            throw new RuntimeException(("You can not withdraw money!"));
        }
        return total;
    }
}

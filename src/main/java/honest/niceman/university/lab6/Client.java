package honest.niceman.university.lab6;

public class Client {
    private int balance;
    private String name;

    public Client(int balance,
                  String name) {
        this.balance = balance;
        this.name = name;
    }

    public boolean add(int amount) {
        if (amount < 0) return false;
        else {
            this.balance += amount;
            return true;
        }
    }

    public boolean pay(int amount) {
        if (balance - amount >= 0) {
            this.balance -= amount;
            return true;
        } else return false;
    }
}

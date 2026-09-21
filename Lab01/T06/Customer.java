public class Customer {
    private int amount;

    public Customer(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void spend(int amount) {
        this.amount -= amount;
    }

    public void set(int amount) {
        this.amount = amount;
    }
}

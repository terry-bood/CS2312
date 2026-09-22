public class Shop {
    private int totalProfit;

    public Shop() {
        this.totalProfit = 0;
    }

    public void earn(Customer customer, int amount) {
        customer.spend(amount);
        this.totalProfit += amount;
    }

    public void earn(Group group, int amount) {
      
        this.totalProfit += amount;
        group.pay(amount); // This line seems unnecessary as it doesn't affect the profit calculation
    }

    public int getProfit() {
        return totalProfit;
    }
}

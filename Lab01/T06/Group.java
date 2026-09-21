public class Group {
    private int count;
    private Customer[] customers;

    public Group() {
        this.customers = new Customer[10]; // Initial capacity of 10
        this.count = 0;
    }

    public void add(Customer customer) {
        if(count <10) {
            customers[count++] = customer;
        } else {
            // Optionally, you can resize the array if needed
            System.out.println("Group is full. Cannot add more customers.");
        }
    }

    public int getCount() {
        return count;
    }

    public void pay(int amount){
        if(count == 0) return; // Avoid division by zero
        int amountPerCustomer = amount / count;
        for(int i = 0; i < count; i++) {
            customers[i].spend(amountPerCustomer);
        }
    }

}
    

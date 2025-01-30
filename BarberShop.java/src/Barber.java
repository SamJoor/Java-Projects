
// Represents a barber
class Barber {
    boolean isAvailable; // Indicates whether the barber is available or not
    Customer currentCustomer; // Customer currently being served by the barber

    // Constructor for the Barber class
    public Barber() {
        isAvailable = true;
        currentCustomer = null;
    }

    // Assigns a customer to the barber for service
    public void serveCustomer(Customer customer) {
        currentCustomer = customer;
        isAvailable = false;
    }

    // Finishes serving the current customer
    public void finishService() {
        currentCustomer = null;
        isAvailable = true;
    }
}
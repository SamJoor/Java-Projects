// Represents a customer
class Customer {
    int arrivalTime; // Time at which the customer arrives
    int serviceTime; // Time required for the service
    String name; // Customer's name

    // Constructor for the Customer class
    public Customer(int arrivalTime, int serviceTime, String name) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.name = name;
    }
}
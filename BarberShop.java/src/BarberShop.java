import java.util.Queue;
import java.util.LinkedList;

//Represents a barber shop
class BarberShop {
 int numChairs; // Number of chairs available in the barber shop
 Barber barber; // Barber in the shop
 Queue<Customer> waitingCustomers; // Queue of customers waiting for service

 // Constructor for the BarberShop class
 public BarberShop(int numChairs) {
     this.numChairs = numChairs;
     barber = new Barber();
     waitingCustomers = new LinkedList<>();
 }

 // Adds a customer to the waiting queue
 public void addCustomer(Customer customer) {
     if (waitingCustomers.size() < numChairs) {
         waitingCustomers.add(customer);
     } else {
         System.out.println("All chairs are full. " + customer.name + " leaves without a haircut.");
     }
 }

 // Prints the status of the barber shop at a given time
 public void printStatus(int time) {
     System.out.println("Time = " + time);
     System.out.println();
     System.out.println("Barber takes a break");
     System.out.println();
     System.out.println("Chairs are empty");
     System.out.println("Barber's chair is empty");
     System.out.println();
     System.out.println("Arrival List");
     if (waitingCustomers.isEmpty()) {
         System.out.println("    No customers waiting.");
     } else {
         for (Customer customer : waitingCustomers) {
             System.out.println("    " + customer.name + ": arrival = " + customer.arrivalTime + ": service = " + customer.serviceTime);
         }
     }
     System.out.println();
     System.out.println("------------------------------");
 }

 // Simulates the barber shop behavior
 public void simulate(int[] arrivalTimes, int[] serviceTimes, String[] customerNames) {
     int currentTime = 0;
     int nextCustomerIndex = 0;

     // Continue simulation until there are no more customers and the barber is not serving anyone
     while (nextCustomerIndex < arrivalTimes.length || !waitingCustomers.isEmpty() || !barber.isAvailable) {
         // Print the status of the barber shop at the current time
         printStatus(currentTime);

         // Check if there is a new customer arriving
         if (nextCustomerIndex < arrivalTimes.length && arrivalTimes[nextCustomerIndex] == currentTime) {
             Customer newCustomer = new Customer(arrivalTimes[nextCustomerIndex], serviceTimes[nextCustomerIndex], customerNames[nextCustomerIndex]);
             addCustomer(newCustomer);
             nextCustomerIndex++;
         }

         // Serve the current customer
         if (!barber.isAvailable) {
             barber.currentCustomer.serviceTime--;
             if (barber.currentCustomer.serviceTime == 0) {
                 barber.finishService();
             }
         }

         // Check if there are waiting customers
         if (!waitingCustomers.isEmpty()) {
             Customer nextCustomer = waitingCustomers.poll();
             barber.serveCustomer(nextCustomer);
         }

         // Move to the next time interval
         currentTime++;
     }
 }
}
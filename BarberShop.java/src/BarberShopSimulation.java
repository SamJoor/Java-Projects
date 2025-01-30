import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BarberShopSimulation {
    public static void main(String[] args) {
        try {
            // Read input from the file
            File inputFile = new File("barberInput.txt");
            Scanner scanner = new Scanner(inputFile);

            // Count the number of customers in the file
            int numCustomers = 0;
            while (scanner.hasNextLine()) {
                numCustomers++;
                scanner.nextLine();
            }
            scanner.close();

            // Initialize arrays to store arrival times, service times, and customer names
            int[] arrivalTimes = new int[numCustomers];
            int[] serviceTimes = new int[numCustomers];
            String[] customerNames = new String[numCustomers];

            // Read data from the file and populate the arrays
            scanner = new Scanner(inputFile);
            int index = 0;
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("\t");
                arrivalTimes[index] = Integer.parseInt(parts[0]);
                serviceTimes[index] = Integer.parseInt(parts[1]);
                customerNames[index] = parts[2];
                index++;
            }
            scanner.close();

            // Set number of chairs
            int numChairs = 3; // You can change this to read from input if needed

            // Create a BarberShop object and simulate the barber shop behavior
            BarberShop barberShop = new BarberShop(numChairs);
            barberShop.simulate(arrivalTimes, serviceTimes, customerNames);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
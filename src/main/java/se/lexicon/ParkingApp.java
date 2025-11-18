package se.lexicon;

import se.lexicon.dao.impl.CustomerDaoImpl;
import se.lexicon.dao.impl.ParkingSpotDaoImpl;
import se.lexicon.dao.impl.ReservationDaoImpl;
import se.lexicon.model.Customer;
import java.util.Scanner;

public class ParkingApp {

    private final CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
    private final ParkingSpotDaoImpl parkingSpotDaoImpl = new ParkingSpotDaoImpl();
    private final ReservationDaoImpl reservationDaoImpl = new ReservationDaoImpl();

    // TODO: needs completions

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                    1. Register Customer
                    2. Display Parking Spots
                    3. Reserve a Parking Spot
                    4. Vacate Parking Spot
                    5. Exit
                    """);

            String choice = getInput("Choose an option: ");
            switch (choice) {
                case "1" -> registerCustomer();
                case "2" -> displayParkingSpots();
                case "3" -> reserveParkingSpot();
                case "4" -> vacateParkingSpot();
                case "5" -> {
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }


    private void registerCustomer() {
        System.out.println("=== Register Customer ===");

        String name = getInput("Enter name: ");
        String phone = getInput("Enter phone number: ");
        String plate = getInput("Enter vehicle plate number: ");

        Customer customer = new Customer(null, name, phone, plate);
        //customerDaoImpl.create(customer);

        System.out.println("Customer registered: " + customer);
    }

    private void displayParkingSpots() {

    }

    private void reserveParkingSpot() {

    }

    private void vacateParkingSpot() {

    }

    private String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }
}

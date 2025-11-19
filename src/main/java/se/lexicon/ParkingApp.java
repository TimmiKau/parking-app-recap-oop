package se.lexicon;

import se.lexicon.dao.CustomerDao;
import se.lexicon.dao.impl.CustomerDaoImpl;
import se.lexicon.dao.impl.ParkingSpotDaoImpl;
import se.lexicon.dao.impl.ReservationDaoImpl;
import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Reservation;
import se.lexicon.model.Status;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public class ParkingApp {

    private final CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
    private final ParkingSpotDaoImpl parkingSpotDaoImpl = new ParkingSpotDaoImpl();
    private final ReservationDaoImpl reservationDaoImpl = new ReservationDaoImpl();




    // TODO: needs completions

    public void start() {

        //Load parkingspot
        loadParkingSpots();

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
                case "4" -> {vacateParkingSpot();
                }
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

        Customer customer = new Customer(name, phone, plate);
        customerDaoImpl.create(customer);

        System.out.println("Customer registered: " + customer);
    }

    private void displayParkingSpots() {
        System.out.println("=== Display Available Parking Spots ===");
        System.out.println(parkingSpotDaoImpl.findAll());
    }

    private void reserveParkingSpot() {

        System.out.println("=== Reserve Parking Spot ===");
        System.out.println(parkingSpotDaoImpl.findAvailableSpots());

        //Book by CostumerID
        String customerIdInput = getInput("Enter customer ID in: ");
        int customerId = Integer.parseInt(customerIdInput);

        //Check if customer exist
        Optional<Customer> customerOpt = customerDaoImpl.findById(customerId);

        if (customerOpt.isEmpty()) {
            System.out.println("Customer with ID: " + customerId + " not found!");
            return;
        }

        //Return if opt is not null
        Customer costumer = customerOpt.get();

        //Choose a parking space
        String spotInput = getInput("Enter spot number: ");
        int spotNumber = Integer.parseInt(spotInput);

        //Add the parkingspot with the parkispotdaoimpl
        Optional<ParkingSpot>  parkingSpotOpt = parkingSpotDaoImpl.findBySpotNumber(spotNumber); // Before findBySpotNumber

        //check if empty ( correct input )
        if (parkingSpotOpt.isEmpty()) {
            System.out.println("Parking Spot with ID: " + spotNumber + " not found!");
            return;
        }

        //Get parkingspot
        ParkingSpot parkingSpot = parkingSpotOpt.get();

        //check if its occupid or not
        if (parkingSpot.isOccupied()) {
            System.out.println("Parking Spot with ID: " + spotNumber + " is occupied!");
            return;
        }

        //create a reservation
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(1);

        Reservation reservation = new Reservation(
                java.util.UUID.randomUUID().toString(),
                costumer,
                parkingSpot,
                Status.ACTIVE,
                endTime,
                startTime
        );

        //Save reservation //Not sure of the code in ReservationDaoImpl
        reservationDaoImpl.create(reservation);

        //Update parkingspot avaliabilty
        parkingSpot.setOccupied(true);

        //tell user what happened.
        System.out.println("Parking Spot with ID: " + spotNumber + " has been reserved!");

    }

    private void vacateParkingSpot() {
        System.out.println("=== Vacate Parking Spot ===");

        //user input of parking spot to free
        String userInput = getInput("Enter Reservation id: ");

        //find spot
        Optional<Reservation> reservationOpt = reservationDaoImpl.findById(userInput); //Enter method that makes sense.

        //check if it exist
        if (reservationOpt.isEmpty()) {
            System.out.println("Reservation ID: " + userInput + " not found!");
            return;
        }

        //Get reservation
        Reservation reservation = reservationOpt.get();

        //check if already free
        if (!reservation.getParkingSpot().isOccupied()){
            System.out.println("Reservation ID: " + userInput + " is not occupied!");
        }

        //vacate update sparingspot to avaliable.
        reservation.getParkingSpot().setOccupied(false);

        //Print what happened.
        System.out.println("You have vacate your parking spot");
    }

    private String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }

    private void loadParkingSpots() {
        parkingSpotDaoImpl.create(new ParkingSpot(1, 100, false));
        parkingSpotDaoImpl.create(new ParkingSpot(2, 100, false));
        parkingSpotDaoImpl.create(new ParkingSpot(3, 100, true));
    }

}

package se.lexicon.model;

import java.time.LocalDateTime;

/**
 * Represents a reservation made by a customer for a specific parking spot.
 * <p>
 * A reservation records which customer reserved which parking spot,
 * along with the start and end time of the reservation and its current status.
 */
public class Reservation {

    private String reservationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;
    private ParkingSpot parkingSpot;
    private Customer customer;

    // TODO: Add constructors
    public Reservation(String reservationId, Customer customer, ParkingSpot parkingSpot, Status status, LocalDateTime endTime, LocalDateTime startTime) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.parkingSpot = parkingSpot;
        this.status = status;
        this.endTime = endTime;
        this.startTime = startTime;
    }


    // TODO: Add getters and setters
    //reservation Id
    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        if(reservationId == null) {
            System.out.println("Reservation Id cannot be empty");
        }
        else {
            this.reservationId = reservationId;
        }

    }


    //start time
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        if(startTime.isBefore(LocalDateTime.now())){
            System.out.println("Start time cannot be in the past.");
        }
        else{
            this.startTime = startTime;
        }
    }


    //end time
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        if (endTime.isBefore(LocalDateTime.now())) {
            System.out.println("End time cannot be in the past.");
        } else if (startTime != null && endTime.isBefore(startTime)) {
            System.out.println("End time cannot be before start time.");
        } else {
            this.endTime = endTime;
        }
    }


    //status
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (this.status == Status.COMPLETED && status == Status.ACTIVE) {
            throw new IllegalStateException("Cannot change status from COMPLETED to ACTIVE.");
        }

        this.status = status;
    }


    //parking spot
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }


    //customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    // TODO: Add toString() if needed

    @Override
    public String toString() {
        return "Reservation: " + '\'' +
                "id: " + reservationId + ", Start time: " + startTime + '\'' +
                ", End time: " + endTime + '\'' + ", Status: " + status + '\'' +
                ", Parking Spot: " + parkingSpot + '\'' + " Customer: " + customer + '\'';
    }


    /**
     * Marks the reservation as completed.
     * Changes status from ACTIVE to COMPLETED.
     */

    public void complete() {
        // TODO: Implement by setting status to COMPLETED
        if(this.status == Status.ACTIVE) {
            this.setStatus(Status.COMPLETED);
        }
        else  {
            System.out.println("Only Active can be completed.");
        }
    }

    /**
     * Sets the end time of the reservation based on a duration.
     *
     * @param hours Number of hours for the reservation
     */
    public void setEndTimeByHours(int hours) {
        // TODO: Implement by adding hours to startTime\
        if (startTime == null) {
            System.out.println("Start time must be set before setting end time.");
        }
        if (hours <= 0) {
            System.out.println("Hours must be greater than zero.");
        }
        else {
            this.endTime = startTime.plusHours(hours);
        }
    }
}

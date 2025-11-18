package se.lexicon.model;

import se.lexicon.dao.sequencer.CustomerIdSequencer;

import static se.lexicon.dao.sequencer.CustomerIdSequencer.nextId;

/**
 * Represents a customer who uses the parking reservation system.
 * <p>
 * Each customer has a unique ID, personal contact information,
 * and the vehicle's plate number associated with them.
 * <p>
 * This class is used when creating reservations and managing
 * parking activity in the application.
 */
public class Customer {

    // Fields
    private Integer id;
    private String name;
    private String phoneNumber;
    private String vehiclePlatNumber;

    // TODO: Add constructors
    public Customer(String name, String phoneNumber, String vehiclePlateNumber) {
        this.id = nextId();
        setName(name);
        setPhoneNumber(phoneNumber);
        setVehiclePlateNumber(vehiclePlateNumber);
    }
    // TODO: Add getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlatNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlatNumber) {
        this.vehiclePlatNumber = vehiclePlatNumber;
    }

    // TODO: Add toString() method if needed
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", vehiclePlateNumber='" + vehiclePlatNumber + '\'' +
                '}';
    }
}

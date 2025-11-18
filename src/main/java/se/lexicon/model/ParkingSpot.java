package se.lexicon.model;

/**
 * Represents a physical parking spot in the parking area.
 * <p>
 * Each parking spot is identified by a unique spot number and an area code.
 * The spot may either be available or currently occupied.
 * <p>
 * This class is used when displaying parking availability and when assigning a spot
 * to a customer's reservation.
 */
public class ParkingSpot {

    private Integer spotNumber;
    private Integer areaCode;
    private boolean occupied;

    // TODO: Add constructors
    public ParkingSpot(Integer spotNumber, Integer areaCode, boolean occupied) {
        setSpotNumber(spotNumber);
        setAreaCode(areaCode);
        setOccupied(occupied);
    }

    // TODO: Add getters and setters
    public Integer getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Integer spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
    // TODO: Add toString() if needed
    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", areaCode=" + areaCode +
                ", occupied=" + occupied +
                '}';
    }
    /**
     * Marks the parking spot as occupied.
     * This method sets the `occupied` field to true.
     */
    public void occupy() {
        this.occupied = true;
    }

    /**
     * Marks the parking spot as vacant.
     * This method sets the `occupied` field to false.
     */
    public void vacate() {
        this.occupied = false;
    }
}
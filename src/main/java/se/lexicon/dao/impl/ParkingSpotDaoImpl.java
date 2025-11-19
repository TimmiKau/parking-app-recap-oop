package se.lexicon.dao.impl;

import se.lexicon.dao.ParkingSpotDao;
import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ParkingSpotDaoImpl implements ParkingSpotDao {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();


    @Override
    public ParkingSpot create(ParkingSpot parkingSpot) {
        for (ParkingSpot slot : parkingSpots){
            if (slot.getSpotNumber().equals(parkingSpot.getSpotNumber())&&
                    slot.getAreacode().equals(parkingSpot.getAreacode())){
                throw new RuntimeException("Parking slot do exist");
            }
        }
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    @Override
    public List<ParkingSpot> findAll() {
        return parkingSpots;
    }

    @Override
    public Optional<ParkingSpot> findBySpotNumber(Integer spotNumber) {
        for (ParkingSpot parkingSpot: parkingSpots){
            if (parkingSpot.getSpotNumber().equals(spotNumber)){
                return Optional.of(parkingSpot);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<ParkingSpot> findAvailableSpots() {
        List<ParkingSpot> avaliableSlot = new ArrayList<>();
        for (ParkingSpot slot : parkingSpots){
            if( !slot.isOccupied()){
                avaliableSlot.add(slot);
            }
        }
        return avaliableSlot;
    }

    @Override
    public void update(ParkingSpot parkingSpot) {
        for (ParkingSpot slot : parkingSpots){
            if (slot.getSpotNumber().equals(parkingSpot.getSpotNumber())){
                slot.setOccupied(parkingSpot.isOccupied());
                return;
            }
        }

    }
}





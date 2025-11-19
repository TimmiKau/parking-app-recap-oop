package se.lexicon.dao.impl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.ParkingSpotDao;
import se.lexicon.model.ParkingSpot;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class ParkingSpotDaoImplTest {
   ParkingSpot parkingSpot1 = new ParkingSpot(1,5,false);
   //ParkingSpot parkingSpot2 = new ParkingSpot(2,10,true);
    ParkingSpotDao ParkingSpotDao;


   @BeforeEach
   void setUp(){
   ParkingSpotDao = new ParkingSpotDaoImpl();
   }
    @Test
    void createNewParkingSlot() {
        ParkingSpot testSlot = ParkingSpotDao.create(parkingSpot1);
       assertEquals(parkingSpot1,testSlot);

    }

    @Test
    void findAll() {
        ParkingSpotDao.create(parkingSpot1);
        List<ParkingSpot> spots=ParkingSpotDao.findAll();
        assertEquals(1,spots.size());
        assertEquals(parkingSpot1,spots.get(0));
    }

    @Test
    void findBySpotNumber() {
       ParkingSpotDao.create(parkingSpot1);
        Optional<ParkingSpot> slotFound=ParkingSpotDao.findBySpotNumber(parkingSpot1.getSpotNumber());
        assertTrue(slotFound.isPresent());
        assertFalse(slotFound.isEmpty());

    }

    @Test
    void findAvailableSpots() {
       ParkingSpotDao.create(parkingSpot1);
       List<ParkingSpot> availableSlot = ParkingSpotDao.findAvailableSpots();
       assertEquals(1,availableSlot.size());
       assertTrue(availableSlot.contains(parkingSpot1));
    }

    @Test
    void update() {
       ParkingSpotDao.create(parkingSpot1);
       ParkingSpot updatedSlot= new ParkingSpot(2,10,false);
       ParkingSpotDao.update(updatedSlot);


    }
}
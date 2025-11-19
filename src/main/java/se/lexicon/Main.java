package se.lexicon;

import se.lexicon.ParkingApp;
import se.lexicon.dao.impl.ParkingSpotDaoImpl;
import se.lexicon.model.ParkingSpot;

public class Main {
    public static void main(String[] args) {

        ParkingSpot parkingSpot1 = new ParkingSpot(1,2,false);

        ParkingApp parkingApp = new ParkingApp();
        parkingApp.start();

    }
}
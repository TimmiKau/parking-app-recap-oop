package se.lexicon;

import se.lexicon.ParkingApp;
import se.lexicon.dao.impl.ParkingSpotDaoImpl;
import se.lexicon.model.ParkingSpot;

public class Main {
    public static void main(String[] args) {

        ParkingApp parkingApp = new ParkingApp();
        parkingApp.start();

    }
}
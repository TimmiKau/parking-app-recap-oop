package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class ReservationTest {


    private Reservation createBasicReservation() {
        Customer customer = new Customer("John Doe","12345678", "123abc");
        ParkingSpot spot = new ParkingSpot(1, 100, true);
        LocalDateTime start = LocalDateTime.now().plusHours(1);
        LocalDateTime end = start.plusHours(2);
        return new Reservation("Resorvation 1", customer, spot, Status.ACTIVE, end, start);
    }


    //Setters
    //Id
    @Test
    public void testSetReservationIdValid() {
        Reservation reservation = createBasicReservation();
        reservation.setReservationId("NEW_ID");
        assertEquals("NEW_ID", reservation.getReservationId());
    }

    @Test
    public void testSetReservationIdNull() {
        Reservation reservation = createBasicReservation();
        reservation.setReservationId(null); // should NOT change id
        assertEquals("Resorvation 1", reservation.getReservationId());
    }


    //Start time
    @Test
    public void testSetStartTimeValid() {
        Reservation reservation = createBasicReservation();
        LocalDateTime newStart = LocalDateTime.now().plusHours(2);
        reservation.setStartTime(newStart);
        assertEquals(newStart, reservation.getStartTime());
    }

    @Test
    public void testSetStartTimeInPast() {
        Reservation reservation = createBasicReservation();
        LocalDateTime pastTime = LocalDateTime.now().minusHours(5);
        reservation.setStartTime(pastTime);
        assertNotEquals(pastTime, reservation.getStartTime());
    }


    //End time
    @Test
    public void testSetEndTimeValid() {
        Reservation reservation = createBasicReservation();
        LocalDateTime newEnd = LocalDateTime.now().plusHours(2);
        reservation.setEndTime(newEnd);
        assertEquals(newEnd, reservation.getEndTime());
    }

    @Test
    public void testSetEndTimeBeforeNow() {
        Reservation reservation = createBasicReservation();
        LocalDateTime past = LocalDateTime.now().minusHours(3);
        reservation.setEndTime(past);
        assertNotEquals(past, reservation.getEndTime());
    }


    //Status
    @Test
    public void testSetStatusValid() {
        Reservation reservation = createBasicReservation();
        reservation.setStatus(Status.ACTIVE);
        assertEquals(Status.ACTIVE, reservation.getStatus());
    }

    @Test
    public void testSetStatusInvalid() {
        Reservation reservation = createBasicReservation();
        reservation.setStatus(Status.COMPLETED);
        assertNotEquals(Status.ACTIVE, reservation.getStatus());
    }




    //Complete
    @Test
    public void testCompleteMethod() {
        Reservation reservation = createBasicReservation();
        reservation.complete();
        assertEquals(Status.COMPLETED, reservation.getStatus());
    }

    @Test
    public void testIncompleteMethod() {
        Reservation reservation = createBasicReservation();
        reservation.setStatus(Status.COMPLETED);
        reservation.complete();
        assertEquals(Status.COMPLETED, reservation.getStatus());
    }


    //setEndTimeByHours
    @Test
    public void testSetEndTimeByHoursValid() {
        Reservation reservation = createBasicReservation();
        reservation.setEndTimeByHours(5);
        assertEquals(reservation.getStartTime().plusHours(5), reservation.getEndTime());
    }

    @Test
    public void testSetEndTimeByHoursInvalid() {
        Reservation reservation = createBasicReservation();
        reservation.setEndTimeByHours(-1);
        assertNotEquals(reservation.getStartTime().plusHours(5), reservation.getEndTime());
    }

}

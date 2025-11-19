package se.lexicon.dao.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Reservation;
import se.lexicon.model.Status;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ReservationDaoImplTest {

    private ReservationDaoImpl reservationDao;

    @BeforeEach
    void setUp() {
        reservationDao = new ReservationDaoImpl();
    }

    @Test
    void testCreateAndFindById() {
        Reservation reservation = createSampleReservation("ABC123");

        reservationDao.create(reservation);

        Optional<Reservation> result = reservationDao.findById("ABC123");

        assertTrue(result.isPresent());
        assertEquals("ABC123", result.get().getReservationId());
    }

    @Test
    void testFindAll() {
        reservationDao.create(createSampleReservation("A"));
        reservationDao.create(createSampleReservation("B"));

        assertEquals(2, reservationDao.findAll().size());
    }

    @Test
    void testUpdate() {
        Reservation r = createSampleReservation("R1");
        reservationDao.create(r);

        r.setStatus(Status.COMPLETED);
        reservationDao.update(r);

        Optional<Reservation> result = reservationDao.findById("R1");

        assertTrue(result.isPresent());
        assertEquals(Status.COMPLETED, result.get().getStatus());
    }


    private Reservation createSampleReservation(String id) {
        Customer customer = new Customer("Test", "123", "ABC123");
        ParkingSpot spot = new ParkingSpot(1, 101, false);

        return new Reservation(
                id,
                customer,
                spot,
                Status.ACTIVE,
                LocalDateTime.now().plusHours(1),
                LocalDateTime.now()
        );
    }
}

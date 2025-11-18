package se.lexicon.dao.impl;

import se.lexicon.dao.ReservationDao;
import se.lexicon.model.Reservation;

import java.util.*;

/**
 * Simple in-memory implementation of ReservationDao.
 * Stores reservations in a Map<String, Reservation>.
 */
public class ReservationDaoImpl implements ReservationDao {


    private final Map<String, Reservation> reservations = new HashMap<>();

    @Override
    public Reservation create(Reservation reservation) {
        reservations.put(reservation.getReservationId(), reservation);
        return reservation;
    }

    @Override
    public Optional<Reservation> findById(String reservationId) {
        return Optional.ofNullable(reservations.get(reservationId));
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(reservations.values());
    }


    @Override
    public void update(Reservation reservation) {
        reservations.put(reservation.getReservationId(), reservation);
    }
}

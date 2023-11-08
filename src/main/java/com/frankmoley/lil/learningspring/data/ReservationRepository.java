package com.frankmoley.lil.learningspring.data;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
	Iterable<Reservation> findReservationByReservationDate(Date date);

}

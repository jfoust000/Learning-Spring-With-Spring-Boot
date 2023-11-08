package com.frankmoley.lil.learningspring.util;

import com.frankmoley.lil.learningspring.data.RoomRepository;

import java.util.Date;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.frankmoley.lil.learningspring.data.Room;
import com.frankmoley.lil.learningspring.business.ReservationService;
import com.frankmoley.lil.learningspring.business.RoomReservation;
import com.frankmoley.lil.learningspring.data.Guest;
import com.frankmoley.lil.learningspring.data.GuestRepository;
import com.frankmoley.lil.learningspring.data.Reservation;
import com.frankmoley.lil.learningspring.data.ReservationRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
	
    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
	
		this.reservationService = reservationService;
		this.dateUtils = dateUtils;
		
	}


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
    	
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);
        
    }

}
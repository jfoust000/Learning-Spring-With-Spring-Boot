package com.frankmoley.lil.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frankmoley.lil.learningspring.business.ReservationService;
import com.frankmoley.lil.learningspring.business.RoomReservation;
import com.frankmoley.lil.learningspring.util.DateUtils;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

	private final DateUtils dateUtils;
	private final ReservationService reservationService;
	
	public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
		
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
		
	}
	
	@GetMapping
	public String getReservations(String dateString, Model model ) {
		
		Date date = this.dateUtils.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		return "roomres";
		
	}
	
}

package com.frankmoley.lil.learningspring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frankmoley.lil.learningspring.business.HotelGuest;
import com.frankmoley.lil.learningspring.business.HotelGuestService;
import com.frankmoley.lil.learningspring.business.HotelRoom;
import com.frankmoley.lil.learningspring.business.HotelRoomService;
import com.frankmoley.lil.learningspring.business.ReservationService;
import com.frankmoley.lil.learningspring.business.RoomReservation;
import com.frankmoley.lil.learningspring.util.DateUtils;

@RestController
@RequestMapping("/api")
public class WebserviceController {

	private final DateUtils dateUtils;
	private final ReservationService reservationService;
	private final HotelGuestService hotelGuestService;
	private final HotelRoomService hotelRoomService;
	
	public WebserviceController(DateUtils dateUtils, ReservationService reservationService,
			HotelGuestService hotelGuestService,
			HotelRoomService hotelRoomService) {
	
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
		this.hotelGuestService = hotelGuestService;
		this.hotelRoomService = hotelRoomService;
		
	}
	
	@GetMapping("/reservations")
	public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString) {
		
		Date date = this.dateUtils.createDateFromDateString(dateString);
		return this.reservationService.getRoomReservationsForDate(date);
		
	}
	
	@GetMapping("/guests")
	public List<HotelGuest> getGuests() {

		return this.hotelGuestService.getAllGuests();

	}
	
	@GetMapping("/rooms")
	public List<HotelRoom> getRooms() {
		
		return this.hotelRoomService.getAllRooms();
		
	}
	
	@PostMapping("/guests")
	@ResponseStatus(HttpStatus.CREATED)
	public HotelGuest createGuest(@RequestBody HotelGuest hotelGuest) {
			
		return hotelGuestService.createGuest(hotelGuest);
		
	}
	
	
	
}

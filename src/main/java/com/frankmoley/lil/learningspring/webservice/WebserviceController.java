package com.frankmoley.lil.learningspring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frankmoley.lil.learningspring.business.HotelDataTransactionResult;
import com.frankmoley.lil.learningspring.business.HotelGuest;
import com.frankmoley.lil.learningspring.business.HotelGuestService;
import com.frankmoley.lil.learningspring.business.ReservationService;
import com.frankmoley.lil.learningspring.business.RoomReservation;
import com.frankmoley.lil.learningspring.util.DateUtils;

@RestController
@RequestMapping("/api")
public class WebserviceController {

	private final DateUtils dateUtils;
	private final ReservationService reservationService;
	private final HotelGuestService hotelGuestService;
	
	public WebserviceController(DateUtils dateUtils, ReservationService reservationService,
			HotelGuestService hotelGuestService) {
	
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
		this.hotelGuestService = hotelGuestService;
		
	}
	
	@GetMapping("/reservations")
	public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString) {
		
		Date date = this.dateUtils.createDateFromDateString(dateString);
		return this.reservationService.getRoomReservationsForDate(date);
		
	}
	
	@GetMapping("list-guests")
	public List<HotelGuest> getGuests() {
		
		List<HotelGuest> hotelGuests = this.hotelGuestService.getAllGuests();
		return hotelGuests;
		
	}
	
	@PostMapping("add-guest")
	public HotelDataTransactionResult addGuest(@RequestBody HotelGuest hotelGuest) {
			
		HotelDataTransactionResult transactionResult = new HotelDataTransactionResult();
		
			if (hotelGuest.getFirstName().equals(null) || hotelGuest.getLastName().equals(null)
					|| hotelGuest.getEmailAddress().equals(null)
					|| hotelGuest.getAddress().equals(null)
					|| hotelGuest.getCountry().equals(null)
					|| hotelGuest.getPhoneNumber().equals(null)) {
				
				transactionResult.setHotelDataTransferObject(hotelGuest);
				transactionResult.setMessage("firstName, lastName, emailAddress, address, country, and phone number are required");
				
				return transactionResult;
				
			}
			
			transactionResult = hotelGuestService.addGuest(hotelGuest);
			
			return transactionResult;
		
	}
	
	
	
}

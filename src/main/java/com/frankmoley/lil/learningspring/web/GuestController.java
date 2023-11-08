package com.frankmoley.lil.learningspring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frankmoley.lil.learningspring.business.HotelGuest;
import com.frankmoley.lil.learningspring.business.HotelGuestService;

@Controller
@RequestMapping("/hotel-guests")
public class GuestController {
	
	private final HotelGuestService hotelGuestService;
	
	public GuestController(HotelGuestService hotelGuestService) {
		
		this.hotelGuestService = hotelGuestService;
		
	}

	@GetMapping
	public String getGuests(Model model) {
		
		List<HotelGuest> hotelGuests = this.hotelGuestService.getAllGuests();
		model.addAttribute("hotelGuests", hotelGuests);
		return "guests";
		
	}

	
}

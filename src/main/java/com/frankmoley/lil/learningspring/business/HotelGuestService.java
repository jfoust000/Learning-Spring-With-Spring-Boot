package com.frankmoley.lil.learningspring.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.frankmoley.lil.learningspring.data.Guest;
import com.frankmoley.lil.learningspring.data.GuestRepository;

@Service
public class HotelGuestService {
	
	private final GuestRepository guestRepository;

	public HotelGuestService(GuestRepository guestRepository) {
	
		this.guestRepository = guestRepository;
		
	}

	public List<HotelGuest> getAllGuests() {
		
		Iterable<Guest> guests = this.guestRepository.findAll();
		
		List<HotelGuest> guestList = new ArrayList<>();
		
		guests.forEach(guest -> {
			
			HotelGuest hotelGuest = new HotelGuest();
			
			hotelGuest.setGuestId(guest.getId());
			hotelGuest.setLastName(guest.getLastName());
			hotelGuest.setFirstName(guest.getFirstName());
			hotelGuest.setEmailAddress(guest.getEmailAddress());
			hotelGuest.setAddress(guest.getAddress());
			hotelGuest.setCountry(guest.getCountry());
			hotelGuest.setState(guest.getState());
			hotelGuest.setPhoneNumber(guest.getPhoneNumber());
			
			guestList.add(hotelGuest);
			
		});
		
		guestList.sort(new Comparator<HotelGuest>() {
					
					@Override
					public int compare(HotelGuest o1, HotelGuest o2) {
						
						if (o1.getLastName().equals(o2.getLastName())) {
							
							return o1.getFirstName().compareTo(o2.getFirstName());
							
						}
						
						return o1.getLastName().compareTo(o2.getLastName());
						
					}
					
				});
		
		return guestList;
		
	}
	
	public HotelGuest createGuest(HotelGuest hotelGuest) {
		
		if (hotelGuest == null) {
			throw new RuntimeException("HotelGuest cannot be null");
		}
		
		Guest guest = new Guest();
	
		guest.setFirstName(hotelGuest.getFirstName());
		guest.setLastName(hotelGuest.getLastName());
		guest.setEmailAddress(hotelGuest.getEmailAddress());
		guest.setAddress(hotelGuest.getAddress());
		guest.setCountry(hotelGuest.getCountry());
		guest.setState(hotelGuest.getState());
		guest.setPhoneNumber(hotelGuest.getPhoneNumber());
	
		guestRepository.save(guest);
		
		hotelGuest.setGuestId(guest.getId());
		
		return hotelGuest;
		
	}	
	
}

package com.frankmoley.lil.learningspring.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.frankmoley.lil.learningspring.data.Room;
import com.frankmoley.lil.learningspring.data.RoomRepository;

@Service
public class HotelRoomService {
	
	private final RoomRepository roomRepository;

	public HotelRoomService(RoomRepository roomRepository) {
		
		this.roomRepository = roomRepository;
		
	}
	
	public List<HotelRoom> getAllRooms() {
		
		Iterable<Room> rooms = this.roomRepository.findAll();
		
		List<HotelRoom> roomList = new ArrayList<>();
		
		rooms.forEach(room -> {
			
			HotelRoom hotelRoom = new HotelRoom();
			
			hotelRoom.setRoomId(room.getId());
			hotelRoom.setName(room.getName());
			hotelRoom.setRoomNumber(room.getRoomNumber());
			hotelRoom.setBedInfo(room.getBedInfo());
			
			roomList.add(hotelRoom);
			
		});
		
		roomList.sort(new Comparator<HotelRoom>() {
			
			@Override
			public int compare(HotelRoom o1, HotelRoom o2) {
				
				if (o1.getName().equals(o2.getName())) {
					
					return o1.getRoomNumber().compareTo(o2.getRoomNumber());
					
				}
				
				return o1.getName().compareTo(o2.getName());
				
			}
			
		});

		return roomList;
		
	}
	
	
	

}

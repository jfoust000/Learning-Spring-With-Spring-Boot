package com.frankmoley.lil.learningspring.business;

public class HotelRoom {

	private long roomId;
	private String name;
	private String roomNumber;
	private String bedInfo;
	
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBedInfo() {
		return bedInfo;
	}
	public void setBedInfo(String bedInfo) {
		this.bedInfo = bedInfo;
	}
	@Override
	public String toString() {
		return "HotelRoom [name=" + name + ", roomNumber=" + roomNumber + ", bedInfo=" + bedInfo + "]";
	}
	
}

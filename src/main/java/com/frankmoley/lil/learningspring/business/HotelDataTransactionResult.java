package com.frankmoley.lil.learningspring.business;

public class HotelDataTransactionResult {
	
	private Object hotelDataTransferObject;
	private Exception e;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getHotelDataTransferObject() {
		return hotelDataTransferObject;
	}
	public void setHotelDataTransferObject(Object hotelDataObject) {
		this.hotelDataTransferObject = hotelDataObject;
	}
	public Exception getE() {
		return e;
	}
	public void setE(Exception e) {
		this.e = e;
	}	

}

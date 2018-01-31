package com.accolite.sleeppods.model;

public class Room {

	private int id;
	private String roomNumber;
	private int hotelId;
	private String roomDescription;
	
	public Room() {
		super();
	}

	public Room(String roomNumber, int hotelId, String roomDescription) {
		super();
		this.roomNumber = roomNumber;
		this.hotelId = hotelId;
		this.roomDescription = roomDescription;
	}

	public int getHotelId() {
		return hotelId;
	}

	public int getId() {
		return id;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", hotelId=" + hotelId + ", roomDescription=" + roomDescription + "]";
	}
	
}

package com.accolite.sleeppods.model;

import java.sql.Timestamp;

import com.accolite.sleeppods.util.BookingStatus;

public class RoomBooking {

	int crewId;
	int roomId;
	Timestamp checkin;
	Timestamp checkout;
	Timestamp bookingTime;
	BookingStatus status;
	
	public RoomBooking() {
		super();
	}	

	public RoomBooking(int roomId, Timestamp checkin, Timestamp checkout, Timestamp bookingTime, BookingStatus status) {
		super();
		this.roomId = roomId;
		this.checkin = checkin;
		this.checkout = checkout;
		this.bookingTime = bookingTime;
		this.status = status;
	}

	public int getCrewId() {
		return crewId;
	}

	public void setCrewId(int crewId) {
		this.crewId = crewId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Timestamp getCheckin() {
		return checkin;
	}

	public void setCheckin(Timestamp checkin) {
		this.checkin = checkin;
	}

	public Timestamp getCheckout() {
		return checkout;
	}

	public void setCheckout(Timestamp checkout) {
		this.checkout = checkout;
	}

	public Timestamp getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Timestamp bookingTime) {
		this.bookingTime = bookingTime;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	
}

package com.accolite.sleeppods.model;

import java.sql.Timestamp;

import com.accolite.sleeppods.util.BookingStatus;

public class RoomBooking {

	int crewId;
	int roomId;
	int bookingId;
	long checkin;
	long checkout;
	Timestamp bookingTime;
	BookingStatus status;
	Hotel hotel;
	String roomNumber; 

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomBooking() {
		super();
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

	public long getCheckin() {
		return checkin;
	}

	public void setCheckin(long checkin) {
		this.checkin = checkin;
	}

	public long getCheckout() {
		return checkout;
	}

	public void setCheckout(long checkout) {
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

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "RoomBooking [crewId=" + crewId + ", roomId=" + roomId + ", bookingId=" + bookingId + ", checkin="
				+ checkin + ", checkout=" + checkout + ", bookingTime=" + bookingTime + ", status=" + status + "]";
	}

}

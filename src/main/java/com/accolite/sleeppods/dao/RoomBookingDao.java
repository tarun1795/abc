package com.accolite.sleeppods.dao;

import java.util.List;

import javax.sql.DataSource;

import com.accolite.sleeppods.model.Hotel;
import com.accolite.sleeppods.model.RoomBooking;

public interface RoomBookingDao {

	public void setDataSource(DataSource dataSource);

	public boolean confirmBooking(RoomBooking roomBooking);

	public boolean cancelBooking(int bookingId);

	public String getBookingStatus(int bookingId);

	public List<RoomBooking> getAllBookings();

	public List<RoomBooking> getBookingsByCrew(int crewId);

	public Hotel getHotelDetailsByRoomId(int roomId);

	public String getRoomNumberByRoomId(int roomId);

}

package com.accolite.sleeppods.dao;

import javax.sql.DataSource;

import com.accolite.sleeppods.model.RoomBooking;

public interface RoomBookingDao {

	public void setDataSource(DataSource dataSource);

	public boolean confirmBooking(RoomBooking roomBooking);

	public boolean cancelBooking(int bookingId);

	public String getBookingStatus(int bookingId);

}

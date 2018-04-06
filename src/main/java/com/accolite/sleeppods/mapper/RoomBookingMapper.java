package com.accolite.sleeppods.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.sleeppods.model.RoomBooking;
import com.accolite.sleeppods.util.BookingStatus;

public class RoomBookingMapper implements RowMapper<RoomBooking>{

	@Override
	public RoomBooking mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoomBooking booking = new RoomBooking();
		booking.setCrewId(rs.getInt("CREW_ID"));
		booking.setRoomId(rs.getInt("ROOM_ID"));
		booking.setCheckin(rs.getTimestamp("CHECK_IN").getTime());
		booking.setCheckout(rs.getTimestamp("CHECK_OUT").getTime());
		booking.setBookingTime(rs.getTimestamp("BOOKING_TIME"));
		booking.setBookingId(rs.getInt("BOOKING_ID"));
		int bookingStatus = rs.getInt("BOOKING_STATUS_ID");
		switch(bookingStatus) {
		case 1:
			booking.setStatus(BookingStatus.BOOKED);
			break;
		case 2:
			booking.setStatus(BookingStatus.CANCELLED);
			break;
		case 3:
			booking.setStatus(BookingStatus.CHECKED_IN);
			break;
		case 4:
			booking.setStatus(BookingStatus.CHECKED_OUT);
			break;
		}
		return booking;
	
	}

}

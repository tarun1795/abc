package com.accolite.sleeppods.daoimpl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.sleeppods.dao.RoomBookingDao;
import com.accolite.sleeppods.model.RoomBooking;

public class RoomBookingDaoImpl implements RoomBookingDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean confirmBooking(RoomBooking roomBooking) {
		//check if the user is no booking of the user already
		//check if the room is free on the particular slot
		//insert booking record
		return false;
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getBookingStatus(int bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

}

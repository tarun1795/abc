package com.accolite.sleeppods.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.sleeppods.model.Hotel;

public class HotelMapper implements RowMapper<Hotel> {

	private final Logger logger = Logger.getLogger(HotelMapper.class);
	@Override
	public Hotel mapRow(ResultSet rs, int rowNum) {
		Hotel hotel = new Hotel();
		try {
			hotel.setId(rs.getInt("HOTEL_ID"));
			hotel.setName(rs.getString("HOTEL_NAME"));
			hotel.setAddress(rs.getString("HOTEL_ADDRESS"));
			hotel.setPhone(rs.getString("HOTEL_PHONE"));
			hotel.setLat(rs.getDouble("HOTEL_LAT"));
			hotel.setLng(rs.getDouble("HOTEL_LNG"));
		} catch (SQLException e) {
			logger.error("Cannot Map ResultSet to Hotel",e);
		}
		return hotel;
	}

}

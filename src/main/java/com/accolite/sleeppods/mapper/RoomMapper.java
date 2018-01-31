package com.accolite.sleeppods.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.sleeppods.model.Room;

public class RoomMapper implements RowMapper<Room> {

	private final Logger logger = Logger.getLogger(RoomMapper.class);

	@Override
	public Room mapRow(ResultSet rs, int rowNum) {
		Room room = new Room();
		try {
			room.setHotelId(rs.getInt("HOTEL_ID"));
			room.setRoomNumber(rs.getString("ROOM_NUMBER"));
			room.setRoomDescription(rs.getString("ROOM_DESCRIPTION"));
			room.setId(rs.getInt("ROOM_ID"));
		} catch (SQLException e) {
			logger.error("Cannot map ResultSet object to Room",e);
		}
		return room;
	}

}

package com.accolite.sleeppods.daoimpl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.sleeppods.dao.RoomDao;
import com.accolite.sleeppods.model.Room;
import com.accolite.sleeppods.util.Query;


public class RoomDaoImpl implements RoomDao {

	private final Logger logger = Logger.getLogger(RoomDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addNewRoom(Room room) {
		int affectedRows;
		try {
			affectedRows = jdbcTemplate.update(Query.ADDNEWROOM, room.getRoomNumber(), room.getHotelId(),
					room.getRoomDescription());
		} catch (Exception e) {
			logger.error("Cannot add room " + room, e);
			affectedRows = 0;
		}
		return (affectedRows > 0);
	}

	@Override
	public boolean removeRoom(int roomId) {
		int affectedRows;
		try {
			affectedRows = jdbcTemplate.update(Query.REMOVEROOM, roomId);
		} catch (Exception e) {
			logger.error("Cannot remove room with room id " + roomId, e);
			affectedRows = 0;
		}
		return (affectedRows > 0);
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

}

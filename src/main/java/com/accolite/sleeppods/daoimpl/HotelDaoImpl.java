package com.accolite.sleeppods.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.sleeppods.dao.HotelDao;
import com.accolite.sleeppods.mapper.HotelMapper;
import com.accolite.sleeppods.mapper.RoomMapper;
import com.accolite.sleeppods.model.Hotel;
import com.accolite.sleeppods.model.Room;
import com.accolite.sleeppods.util.Query;

public class HotelDaoImpl implements HotelDao {

	private final Logger logger = Logger.getLogger(HotelDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addNewHotel(Hotel hotel) {
		int affectedRows;
		try {
			affectedRows = jdbcTemplate.update(Query.ADDNEWHOTEL, hotel.getName(), hotel.getAddress(), hotel.getPhone(),
					hotel.getLat(), hotel.getLng(), hotel.getCityId());
		} catch (Exception e) {
			logger.error("Error creating hotel " + hotel.getName(), e);
			affectedRows = 0;
		}
		return (affectedRows > 0);
	}

	@Override
	public List<Hotel> getAllHotels() {
		logger.info("Getting all hotel list");
		try {
			return jdbcTemplate.query(Query.GETALLHOTELS, new HotelMapper());
		} catch (Exception e) {
			logger.error("Error getting all hotels", e);
		}
		return new ArrayList<>();
	}

	@Override
	public List<Room> getAllRoomsInHotel(int hotelId) {
		try {
			return jdbcTemplate.query(Query.GETALLROOMSINHOTEL, new Object[] { hotelId }, new RoomMapper());
		} catch (Exception e) {
			logger.error("Cannot get rooms in hotel with id " + hotelId, e);
		}
		return new ArrayList<>();
	}

	@Override
	public int getAvailableCount(int hotelId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Room> getAvailableRooms(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel getHotelDetails(int hotelId) {
		try {
			logger.info("getting hotel with id " + hotelId);
			return jdbcTemplate.queryForObject(Query.GETHOTELDETAILS, new Object[] { hotelId }, new HotelMapper());
		} catch (Exception e) {
			logger.error("Error getting details of hotel id " + hotelId, e);
		}
		return null;
	}

	@Override
	public List<Hotel> getHotelsInCity(int cityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeHotel(int hotelId) {
		int affectedRows;
		try {
			affectedRows = jdbcTemplate.update(Query.REMOVEHOTEL, hotelId);
		} catch (Exception e) {
			logger.error("Error deleting hotel with id " + hotelId, e);
			affectedRows = 0;
		}
		return (affectedRows > 0);
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

}

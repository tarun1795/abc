package com.accolite.sleeppods.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.sleeppods.dao.HotelDao;
import com.accolite.sleeppods.mapper.HotelMapper;
import com.accolite.sleeppods.model.Hotel;
import com.accolite.sleeppods.model.Room;

public class HotelDaoImpl implements HotelDao {

	private final Logger logger = Logger.getLogger(HotelDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean addNewHotel(Hotel hotel) {
		String addNewHotel = "INSERT INTO HOTEL(HOTEL_NAME,HOTEL_ADDRESS,HOTEL_PHONE,HOTEL_LAT,HOTEL_LNG) VALUES (?,?,?,?,?)";
		int affectedRows;
		try {
			affectedRows = jdbcTemplate.update(addNewHotel, hotel.getName(), hotel.getAddress(), hotel.getPhone(),
					hotel.getLat(), hotel.getLng());
		} catch (Exception e) {
			logger.error("Error creating hotel " + hotel.getName(), e);
			affectedRows = 0;
		}
		return (affectedRows > 0);
	}

	@Override
	public boolean addNewRoomToHotel(int hotelId, Room room) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeRoomFromHotel(int hotelId, int roomId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeHotel(int hotelId) {
		String removeHotel = "DELETE FROM HOTEL WHERE HOTEL_ID = ?";
		int affectedRows;
		try {
			affectedRows = jdbcTemplate.update(removeHotel, hotelId);
		} catch (Exception e) {
			logger.error("Error deleting hotel with id " + hotelId, e);
			affectedRows = 0;
		}
		return (affectedRows > 0);
	}

	@Override
	public List<Hotel> getAllHotels() {
		String getAllHotels = "SELECT * FROM HOTEL";
		try {
			return jdbcTemplate.query(getAllHotels, new HotelMapper());
		} catch (Exception e) {
			logger.error("Error getting all hotels", e);
		}
		return new ArrayList<>();
	}

	@Override
	public Hotel getHotelDetails(int hotelId) {
		String getHotelDetails = "SELECT * FROM HOTEL WHERE HOTEL_ID = ?";
		try {
			return jdbcTemplate.queryForObject(getHotelDetails, new Object[] { hotelId }, new HotelMapper());
		} catch (Exception e) {
			logger.error("Error getting details of hotel id " + hotelId, e);
		}
		return null;
	}

}

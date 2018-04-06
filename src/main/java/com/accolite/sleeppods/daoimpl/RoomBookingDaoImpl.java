package com.accolite.sleeppods.daoimpl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.sleeppods.dao.HotelDao;
import com.accolite.sleeppods.dao.RoomBookingDao;
import com.accolite.sleeppods.exception.BadRequestException;
import com.accolite.sleeppods.mapper.HotelMapper;
import com.accolite.sleeppods.mapper.RoomBookingMapper;
import com.accolite.sleeppods.model.Hotel;
import com.accolite.sleeppods.model.Room;
import com.accolite.sleeppods.model.RoomBooking;

public class RoomBookingDaoImpl implements RoomBookingDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	HotelDao hotelDao;

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean confirmBooking(RoomBooking roomBooking) {
		System.out.println(1);
		System.out.println("checkin " + roomBooking.getCheckin());
		System.out.println("checkout " + roomBooking.getCheckout());
		if (roomBooking.getCheckin() < roomBooking.getCheckout()) {
			System.out.println(2);
			// GET HOTEL ID
			String sql = "SELECT HOTEL_ID FROM ROOM WHERE ROOM_ID = ?";
			int hotelId = jdbcTemplate.queryForObject(sql, new Object[] { roomBooking.getRoomId() }, Integer.class);
			System.out.println(3);
			System.out.println("hotel ID " + hotelId);
			// GET AVAILABLE ROOMS IN HOTEL
			Timestamp checkin = new Timestamp(roomBooking.getCheckin());
			System.out.println(checkin.getTimezoneOffset());
			System.out.println(checkin.getTime());
			System.out.println(checkin);
			System.out.println("---");
			java.util.Date chec = new Date(roomBooking.getCheckin());
			System.out.println(chec.toString());
			Timestamp checkout = new Timestamp(roomBooking.getCheckout());
			List<Room> roomsInHotel = hotelDao.getAvailableRooms(hotelId, checkin, checkout);
			// IF THE ROOM EXSIST IN THE AVAILABLE ROOM LIST
			boolean roomIsAvailable = false;
			for (int i = 0; i < roomsInHotel.size(); i++) {
				Room room = roomsInHotel.get(i);
				if (room.getId() == roomBooking.getRoomId()) {
					System.out.println("inside if the final one");
					roomIsAvailable = true;
					String bookingSql = "INSERT INTO CREW_ROOM_BOOKING(ROOM_ID, CREW_ID, CHECK_IN, CHECK_OUT) VALUES (?,?,?,?)";
					int count = jdbcTemplate.update(bookingSql, roomBooking.getRoomId(), roomBooking.getCrewId(),
							checkin, checkout);
					System.out.println("rows affected " + count);
				}
			}
			if (!roomIsAvailable) {
				throw new BadRequestException("ROOM IS ALREADY BOOKED " + roomBooking);
			}
		}
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

	@Override
	public List<RoomBooking> getAllBookings() {
		String sql = "SELECT * FROM CREW_ROOM_BOOKING";
		return jdbcTemplate.query(sql, new RoomBookingMapper());
	}

	@Override
	public List<RoomBooking> getBookingsByCrew(int crewId) {
		String sql = "SELECT * FROM CREW_ROOM_BOOKING WHERE CREW_ID = ?";
		return jdbcTemplate.query(sql, new Object[] { crewId }, new RoomBookingMapper());
	}

	@Override
	public Hotel getHotelDetailsByRoomId(int roomId) {
		String sql = "SELECT * FROM HOTEL WHERE HOTEL_ID = (SELECT HOTEL_ID FROM ROOM WHERE ROOM_ID = ?)";
		return jdbcTemplate.queryForObject(sql,  new Object[] {roomId}, new HotelMapper());
	}

	@Override
	public String getRoomNumberByRoomId(int roomId) {
		String sql = "SELECT ROOM_NUMBER FROM ROOM WHERE ROOM_ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {roomId}, String.class);
	}

}

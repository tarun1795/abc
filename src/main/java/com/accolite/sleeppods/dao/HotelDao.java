package com.accolite.sleeppods.dao;

import java.util.List;

import javax.sql.DataSource;

import com.accolite.sleeppods.model.Hotel;
import com.accolite.sleeppods.model.Room;

public interface HotelDao {

	public void setDataSource(DataSource dataSource);

	public boolean addNewHotel(Hotel hotel);

	public boolean addNewRoomToHotel(int hotelId, Room room);

	public boolean removeRoomFromHotel(int hotelId, int roomId);

	public List<Hotel> getAllHotels();

	public Hotel getHotelDetails(int hotelId);

	public boolean removeHotel(int hotelId);

}

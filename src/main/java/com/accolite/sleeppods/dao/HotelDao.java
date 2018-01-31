package com.accolite.sleeppods.dao;

import java.util.List;

import javax.sql.DataSource;

import com.accolite.sleeppods.model.Hotel;
import com.accolite.sleeppods.model.Room;

public interface HotelDao {

	public boolean addNewHotel(Hotel hotel);

	public List<Hotel> getAllHotels();

	public List<Room> getAllRoomsInHotel(int hotelId);

	public int getAvailableCount(int hotelId);

	public List<Room> getAvailableRooms(int hotelId);

	public Hotel getHotelDetails(int hotelId);

	public List<Hotel> getHotelsInCity(int cityId);

	public boolean removeHotel(int hotelId);

	public void setDataSource(DataSource dataSource);

}

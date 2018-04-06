package com.accolite.sleeppods.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.sleeppods.dao.HotelDao;
import com.accolite.sleeppods.exception.BadRequestException;
import com.accolite.sleeppods.model.Hotel;
import com.accolite.sleeppods.model.Room;
import com.accolite.sleeppods.model.CheckinCheckout;

@RestController
@RequestMapping("hotel")
public class HotelController {

	private final Logger logger = Logger.getLogger(HotelController.class);
	@Autowired
	HotelDao hotelDao;

	@PostMapping
	public void addHotel(@RequestBody Hotel hotel) {
		boolean isDone = hotelDao.addNewHotel(hotel);
		if (!isDone) {
			throw new BadRequestException("Could not create hotel with the provided details!");
		}
		logger.info("Hotel " + hotel.getName() + " Created");
	}

	@GetMapping("all")
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = hotelDao.getAllHotels();
		if (hotels.isEmpty()) {
			throw new BadRequestException("Cannot get hotels");
		}
		return hotels;
	}

	@GetMapping("{hotelId}/allRooms")
	public List<Room> getAllRoomsInHotel(@PathVariable int hotelId) {
		List<Room> rooms = hotelDao.getAllRoomsInHotel(hotelId);
		if (rooms.isEmpty()) {
			throw new BadRequestException("Cannot get all rooms from hotel with id " + hotelId);
		}
		return rooms;
	}

	@GetMapping("{hotelId}")
	public Hotel getDetailsOfHotel(@PathVariable int hotelId) {
		Hotel hotel = hotelDao.getHotelDetails(hotelId);
		if (hotel == null) {
			throw new BadRequestException("Cannot get Hotel with id " + hotelId);
		}
		return hotel;
	}

	@DeleteMapping("{hotelId}")
	public void removeHotel(@PathVariable int hotelId) {
		boolean isDone = hotelDao.removeHotel(hotelId);
		if (!isDone) {
			throw new BadRequestException("Could not delete the hotel");
		}
		logger.info("Hotel with id " + hotelId + " Removed");
	}

	@GetMapping("/city/{cityId}")
	public List<Hotel> getHotelsInCity(@PathVariable int cityId) {
		List<Hotel> hotels = hotelDao.getHotelsInCity(cityId);
		if (hotels.isEmpty()) {
			throw new BadRequestException("Cannot find holtels in city with city id " + cityId);
		}
		logger.info("Getting all hotels in city with id " + cityId);
		return hotels;
	}

	@PostMapping("nearby/{lat}/{lng}")
	public List<Hotel> getHotelsNearBy(@PathVariable double lat, @PathVariable double lng, @RequestBody CheckinCheckout checkinCheckout) {

		Date checkin = new Date(checkinCheckout.getCheckin());
		Date checkout = new Date(checkinCheckout.getCheckout());
		return hotelDao.getHotesNearBy(lat, lng, checkin, checkout);
	}
//	
//	@GetMapping("{hotelId}/availableRooms/")
//	public List<Room> getAvailableRooms(@PathVariable int hotelId, @RequestBody CheckinCheckout checkinCheckout) {
//		return hotelDao.getAvailableRooms(hotelId, checkinCheckout.getCheckin(), checkinCheckout.getCheckout());
//	}
}

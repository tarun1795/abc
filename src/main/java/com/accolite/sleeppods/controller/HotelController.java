package com.accolite.sleeppods.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	@DeleteMapping("{hotelId}")
	public void removeHotel(@PathVariable int hotelId) {
		boolean isDone = hotelDao.removeHotel(hotelId);
		if (!isDone) {
			throw new BadRequestException("Could not delete the hotel");
		}
		logger.info("Hotel with id " + hotelId + " Removed");
	}

	@GetMapping("all")
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = hotelDao.getAllHotels();
		if(hotels.isEmpty()) {
			throw new BadRequestException("Cannot get hotels");
		}
		return hotels;
	}

	@GetMapping("{hotelId}")
	public Hotel getDetailsOfHotel(@PathVariable int hotelId) {
		Hotel hotel = hotelDao.getHotelDetails(hotelId);
		if(hotel == null) {
			throw new BadRequestException("Cannot get Hotel with id "+hotelId);
		}
		return hotel;
	}
}

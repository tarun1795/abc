package com.accolite.sleeppods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.sleeppods.dao.RoomBookingDao;
import com.accolite.sleeppods.model.RoomBooking;

@RestController
@RequestMapping("booking")
public class RoomBookingController {

	@Autowired
	RoomBookingDao roomBookingDao;
	
	@PostMapping
	public void confirmBooking(@RequestBody RoomBooking booking) {
		roomBookingDao.confirmBooking(booking);
	}
	
	@GetMapping("all")
	public List<RoomBooking> getAllBookings() {
		return  roomBookingDao.getAllBookings();
	}
	
	@GetMapping("{crewId}")
	public List<RoomBooking> getBookingsByCrew(@PathVariable int crewId) {
		List<RoomBooking> list = roomBookingDao.getBookingsByCrew(crewId);
		for(RoomBooking booking : list) {
			booking.setHotel(roomBookingDao.getHotelDetailsByRoomId(booking.getRoomId()));
			booking.setRoomNumber(roomBookingDao.getRoomNumberByRoomId(booking.getRoomId()));
		}
		return list;
	}
	
}

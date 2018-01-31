package com.accolite.sleeppods.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.sleeppods.dao.RoomDao;
import com.accolite.sleeppods.exception.BadRequestException;
import com.accolite.sleeppods.model.Room;

@RestController
@RequestMapping("room")
public class RoomController {

	private final Logger logger = Logger.getLogger(RoomController.class);

	@Autowired
	RoomDao roomDao;

	@PostMapping
	public void addRoomToHotel(@RequestBody Room room) {
		boolean isDone = roomDao.addNewRoom(room);
		if (!isDone) {
			throw new BadRequestException("Cannot add room " + room);
		}
		logger.info("Added room " + room);
	}

	@DeleteMapping("{roomId}")
	public void removeRoomFromHotel(@PathVariable int roomId) {
		boolean isDone = roomDao.removeRoom(roomId);
		if (!isDone) {
			throw new BadRequestException("Cannot remove room with room id " + roomId);
		}
		logger.info("Deleted room with id " + roomId);
	}
	
}

package com.accolite.sleeppods.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.sleeppods.dao.AdminActionsDao;
import com.accolite.sleeppods.exception.BadRequestException;
import com.accolite.sleeppods.model.City;

@RestController
@RequestMapping("admin")
public class AdminController {

	private final Logger logger = Logger.getLogger(AdminController.class);
	@Autowired
	AdminActionsDao adminActionDao;

	@PostMapping("city/{cityName}")
	public void addNewCity(@PathVariable String cityName) {

		boolean isDone = adminActionDao.addNewCity(cityName);
		if (!isDone) {
			throw new BadRequestException("Cannot create new city with name " + cityName);
		}
		logger.info("Created city with name " + cityName);
	}

	@GetMapping("city/all")
	public List<City> getAllCities() {
		List<City> cities = adminActionDao.getAllCities();
		if (cities.isEmpty()) {
			throw new BadRequestException("Cannot get all cities");
		}
		logger.info("Getting all cities list");
		return cities;
	}

	@DeleteMapping("city/{cityId}")
	public void removeCity(@PathVariable int cityId) {
		boolean isDone = adminActionDao.removeCity(cityId);
		if (!isDone) {
			throw new BadRequestException("Cannot remove city with id " + cityId);
		}
		logger.info("Removed city with id " + cityId);
	}
}

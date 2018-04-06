package com.accolite.sleeppods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.sleeppods.dao.ReportsDao;
import com.accolite.sleeppods.model.MonthCount;
import com.accolite.sleeppods.model.RoomUtilizationReport;

@RestController
@RequestMapping("reports")
public class ReportsController {

	@Autowired
	ReportsDao reportsDao;
	
	@GetMapping("/monthCount/{year}")
	public List<MonthCount> monthVisePilotBookingDetails(@PathVariable int year) {
		return reportsDao.getMonthvisePilotBookingData(year);
	}
	
	@GetMapping("years")
	public List<String> getYears() {
		return reportsDao.getYears();	
	}
	
	@GetMapping("/roomUtilization/{city}/{year}/{month}")
	public RoomUtilizationReport getRoomUtilization(@PathVariable String city, @PathVariable int year, @PathVariable int month) {
		return reportsDao.getRoomUtilization(city, year, month);
	}
}

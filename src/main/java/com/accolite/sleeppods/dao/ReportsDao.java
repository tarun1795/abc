package com.accolite.sleeppods.dao;

import java.util.List;

import javax.sql.DataSource;

import com.accolite.sleeppods.model.MonthCount;
import com.accolite.sleeppods.model.RoomUtilizationReport;

public interface ReportsDao {

	void setDataSource(DataSource dataSource);
	List<MonthCount> getMonthvisePilotBookingData(int year);
	List<String> getYears();
	RoomUtilizationReport getRoomUtilization(String city, int year, int month);
}

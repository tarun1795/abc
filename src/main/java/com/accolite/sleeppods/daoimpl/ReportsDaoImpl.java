package com.accolite.sleeppods.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.accolite.sleeppods.dao.ReportsDao;
import com.accolite.sleeppods.mapper.MonthCountRowMapper;
import com.accolite.sleeppods.mapper.StringRowMapper;
import com.accolite.sleeppods.mapper.UtilizationReportMapper;
import com.accolite.sleeppods.model.MonthCount;
import com.accolite.sleeppods.model.RoomUtilizationReport;
import com.accolite.sleeppods.model.UtilizationReport;

public class ReportsDaoImpl implements ReportsDao {

	
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<MonthCount> getMonthvisePilotBookingData(int year) {
		String sql = "SELECT (EXTRACT(MONTH FROM CHECK_IN))AS MM , COUNT((EXTRACT(MONTH FROM CHECK_IN))) AS COUNT FROM  CREW_ROOM_BOOKING WHERE (EXTRACT(YEAR FROM CHECK_IN)) = ? GROUP BY (EXTRACT(MONTH FROM CHECK_IN))";
		return jdbcTemplate.query(sql, new Object[] {year}, new MonthCountRowMapper());
	}

	@Override
	public List<String> getYears() {
		String sql = "SELECT DISTINCT (EXTRACT(YEAR FROM CHECK_IN)) AS YEARS FROM CREW_ROOM_BOOKING";
		return jdbcTemplate.query(sql, new StringRowMapper());
	}

	@Override
	public RoomUtilizationReport getRoomUtilization(String city, int year, int month) {
		RoomUtilizationReport report = new RoomUtilizationReport();

		String sql = "SELECT COUNT(ROOM_ID) AS COUNT FROM ROOM WHERE HOTEL_ID IN (SELECT HOTEL_ID FROM HOTEL WHERE CITY_ID IN (SELECT CITY_ID FROM CITY WHERE CITY_NAME = ?))";
		int totalRoomCount = jdbcTemplate.queryForObject(sql,new Object[] {city}, Integer.class);
		String sql1 = "SELECT COUNT(ROOM_ID) AS COUNT, EXTRACT(DAY FROM CHECK_IN) AS DAYY FROM CREW_ROOM_BOOKING WHERE EXTRACT(MONTH FROM CHECK_IN) = ? AND EXTRACT(YEAR FROM CHECK_IN) = ? AND ROOM_ID IN (SELECT ROOM_ID AS COUNT FROM ROOM WHERE HOTEL_ID IN (SELECT HOTEL_ID FROM HOTEL WHERE CITY_ID IN (SELECT CITY_ID FROM CITY WHERE CITY_NAME = ?))) GROUP BY EXTRACT(DAY FROM CHECK_IN)";	
		List<UtilizationReport> list = jdbcTemplate.query(sql1,new Object[] {month, year, city}, new UtilizationReportMapper());
		int sum = 0;
		int days = list.size();
		for(int i=0;i<list.size();i++) {
			UtilizationReport r = list.get(i);
			if(report.getMaxUsed() < r.getCount()) {
				report.setMaxUsed(r.getCount());
				report.setMaxOn(r.getDayy());
			}
			if(report.getMinUsed() > r.getCount()) {
				report.setMinUsed(r.getCount());
				report.setMinOn(r.getDayy());
			}
			sum+=r.getCount();
		}
		int avg = sum/days;
		report.setAvgUsed(avg);
		report.setTotalBookingsInMonth(sum);
		report.setTotalRooms(totalRoomCount);
		return report;
	}

}

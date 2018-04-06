package com.accolite.sleeppods.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.sleeppods.model.MonthCount;

public class MonthCountRowMapper implements RowMapper<MonthCount>{

	@Override
	public MonthCount mapRow(ResultSet rs, int rowNum) throws SQLException {
		MonthCount monthCount = new MonthCount();
		monthCount.setMonth(rs.getInt("MM"));
		monthCount.setCount(rs.getInt("COUNT"));
		return monthCount;
	}

	
}

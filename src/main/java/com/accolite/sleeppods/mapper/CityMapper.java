package com.accolite.sleeppods.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.sleeppods.model.City;

public class CityMapper implements RowMapper<City> {

	private final Logger logger = Logger.getLogger(CityMapper.class);

	@Override
	public City mapRow(ResultSet rs, int rowNum) {
		City city = new City();
		try {
			city.setCityId(rs.getInt("CITY_ID"));
			city.setCityName(rs.getString("CITY_NAME"));
		} catch (SQLException e) {
			logger.error("Cannot map to city object", e);
		}
		return city;
	}

}

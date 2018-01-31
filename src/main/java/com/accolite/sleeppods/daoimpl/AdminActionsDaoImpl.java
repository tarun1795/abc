package com.accolite.sleeppods.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.sleeppods.dao.AdminActionsDao;
import com.accolite.sleeppods.mapper.CityMapper;
import com.accolite.sleeppods.model.City;
import com.accolite.sleeppods.util.Query;

public class AdminActionsDaoImpl implements AdminActionsDao {

	private final Logger logger = Logger.getLogger(AdminActionsDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addNewCity(String cityName) {
		cityName = cityName.toUpperCase();
		int affectedRows;
		try {
			affectedRows = jdbcTemplate.update(Query.ADDNEWCITY, cityName);
		} catch (Exception e) {
			logger.error("Error creating city with name " + cityName, e);
			affectedRows = 0;
		}
		return (affectedRows > 0);
	}

	@Override
	public List<City> getAllCities() {
		try {
			return jdbcTemplate.query(Query.GETALLCITIES, new CityMapper());
		} catch (Exception e) {
			logger.error("Cannot get all cities", e);
		}
		return new ArrayList<>();
	}

	@Override
	public boolean removeCity(int cityId) {
		int affectedRows;
		try {
			affectedRows = jdbcTemplate.update(Query.REMOVECITY, cityId);
		} catch (Exception e) {
			logger.error("Could not delete city with id " + cityId, e);
			affectedRows = 0;
		}
		return (affectedRows > 0);
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

}

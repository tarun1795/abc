package com.accolite.sleeppods.dao;

import java.util.List;

import javax.sql.DataSource;

import com.accolite.sleeppods.model.City;

public interface AdminActionsDao {

	public boolean addNewCity(String cityName);

	public List<City> getAllCities();

	public boolean removeCity(int cityId);

	public void setDataSource(DataSource dataSource);

}

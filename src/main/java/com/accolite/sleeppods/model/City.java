package com.accolite.sleeppods.model;

public class City {

	private int cityId;
	private String cityName;

	public City() {
		super();
	}

	public City(String cityName) {
		super();
		this.cityName = cityName;
	}

	public int getCityId() {
		return cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}

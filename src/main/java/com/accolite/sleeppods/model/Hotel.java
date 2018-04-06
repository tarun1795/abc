package com.accolite.sleeppods.model;

import java.util.List;

public class Hotel {

	private int id;
	private String name;
	private String phone;
	private String address;
	private double lat;
	private double lng;
	private int cityId;
	private List<Room> rooms;

	public Hotel() {
		super();
	}

	public Hotel(String name, String phone, String address, double lat, double lng, int cityId) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.cityId = cityId;
	}

	public String getAddress() {
		return address;
	}

	public int getCityId() {
		return cityId;
	}

	public int getId() {
		return id;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", lat=" + lat
				+ ", lng=" + lng + ", cityId=" + cityId + ", rooms=" + rooms + "]";
	}
 

}

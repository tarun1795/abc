package com.accolite.sleeppods.model;

public class Hotel {

	private int id;
	private String name;
	private String phone;
	private String address;
	private double lat;
	private double lng;
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Hotel(String name, String phone, String address, double lat, double lng) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
}

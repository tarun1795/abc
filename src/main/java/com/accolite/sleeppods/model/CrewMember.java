package com.accolite.sleeppods.model;

import com.accolite.sleeppods.util.CrewType;

public class CrewMember {

	private int id;
	private String name;
	private String email;
	private String phone;
	boolean isEnabled;
	CrewType crewType;

	public CrewMember() {
		super();
	}

	public CrewMember(String name, String email, String phone, CrewType crewType) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.crewType = crewType;
	}

	public CrewType getCrewType() {
		return crewType;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setCrewType(CrewType crewType) {
		this.crewType = crewType;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CrewMember [name=" + name + ", email=" + email + ", phone=" + phone + ", crewType=" + crewType + "]";
	}

}

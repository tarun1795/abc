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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public CrewType getCrewType() {
		return crewType;
	}

	public void setCrewType(CrewType crewType) {
		this.crewType = crewType;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "CrewMember [name=" + name + ", email=" + email + ", phone=" + phone + ", crewType=" + crewType + "]";
	}

}

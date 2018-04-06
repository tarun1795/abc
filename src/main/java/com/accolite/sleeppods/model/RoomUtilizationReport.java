package com.accolite.sleeppods.model;

public class RoomUtilizationReport {

	public int getTotalBookingsInMonth() {
		return totalBookingsInMonth;
	}

	public void setTotalBookingsInMonth(int totalBookingsInMonth) {
		this.totalBookingsInMonth = totalBookingsInMonth;
	}

	int totalRooms;
	int avgUsed;
	int maxUsed;
	int maxOn;
	int minUsed;
	int minOn;
	int totalBookingsInMonth;

	public RoomUtilizationReport() {
		super();
		maxUsed = Integer.MIN_VALUE;
		minUsed = Integer.MAX_VALUE;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

	public int getAvgUsed() {
		return avgUsed;
	}

	public void setAvgUsed(int avgUsed) {
		this.avgUsed = avgUsed;
	}

	public int getMaxUsed() {
		return maxUsed;
	}

	public void setMaxUsed(int maxUsed) {
		this.maxUsed = maxUsed;
	}

	public int getMaxOn() {
		return maxOn;
	}

	public void setMaxOn(int maxOn) {
		this.maxOn = maxOn;
	}

	public int getMinUsed() {
		return minUsed;
	}

	public void setMinUsed(int minUsed) {
		this.minUsed = minUsed;
	}

	public int getMinOn() {
		return minOn;
	}

	public void setMinOn(int minOn) {
		this.minOn = minOn;
	}

}

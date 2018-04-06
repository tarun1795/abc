package com.accolite.sleeppods.model;

import java.sql.Date;

public class CheckinCheckout {

	long checkin;
	
	long checkout;
	
	public CheckinCheckout() {
		super();
	}

	public long getCheckin() {
		return checkin;
	}

	public void setCheckin(long checkin) {
		this.checkin = checkin;
	}

	public long getCheckout() {
		return checkout;
	}

	public void setCheckout(long checkout) {
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "checkinCheckout [checkin=" + checkin + ", checkout=" + checkout + "]";
	}
	
}

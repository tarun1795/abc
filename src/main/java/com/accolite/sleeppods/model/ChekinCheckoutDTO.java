package com.accolite.sleeppods.model;

import java.sql.Date;

public class ChekinCheckoutDTO {

	private Date checkin;
	private Date checkout;

	public ChekinCheckoutDTO() {
		super();
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "ChekinCheckoutDTO [checkin=" + checkin + ", checkout=" + checkout + "]";
	}

}

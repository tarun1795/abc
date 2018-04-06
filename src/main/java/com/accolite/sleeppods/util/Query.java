package com.accolite.sleeppods.util;

public class Query {

	// AdminActionsDaoImpl
	public static final String ADDNEWCITY = "INSERT INTO CITY(CITY_NAME) VALUES (?)";
	public static final String GETALLCITIES = "SELECT * FROM CITY";
	public static final String REMOVECITY = "DELETE FROM CITY WHERE CITY_ID = ?";

	// CrewMemberDaoImpl
	public static final String CREATECREWMEMBER = "INSERT INTO CREW_MEMBER (CREW_NAME,CREW_EMAIL,CREW_PHONE,CREW_TYPE_ID) VALUES (?,?,?,(SELECT CREW_TYPE_ID FROM CREW_TYPE WHERE CREW_TYPE_NAME = ?))";
	public static final String DISABLECREWMEMBER = "UPDATE CREW_MEMBER SET ENABLED = 'N' WHERE CREW_ID = ?";
	public static final String ENABLECREWMEMBER = "UPDATE CREW_MEMBER SET ENABLED = 'Y' WHERE CREW_ID = ?";
	public static final String GETALLCREWMEMBERS = "SELECT * FROM CREW_MEMBER JOIN CREW_TYPE ON CREW_TYPE.CREW_TYPE_ID = CREW_MEMBER.CREW_TYPE_ID";
	public static final String GETCREWDETAILS = "SELECT * FROM CREW_MEMBER JOIN CREW_TYPE ON CREW_TYPE.CREW_TYPE_ID = CREW_MEMBER.CREW_TYPE_ID WHERE CREW_EMAIL = ?";
	public static final String REMOVECREWMEMBER = "DELETE FROM CREW_MEMBER WHERE CREW_ID = ?";

	// HotelDaoImpl
	public static final String ADDNEWHOTEL = "INSERT INTO HOTEL(HOTEL_NAME,HOTEL_ADDRESS,HOTEL_PHONE,HOTEL_LAT,HOTEL_LNG,CITY_ID) VALUES (?,?,?,?,?,?)";
	public static final String GETALLHOTELS = "SELECT * FROM HOTEL";
	public static final String GETALLROOMSINHOTEL = "SELECT * FROM ROOM WHERE HOTEL_ID = ?";
	public static final String GETHOTELDETAILS = "SELECT * FROM HOTEL WHERE HOTEL_ID = ?";
	public static final String REMOVEHOTEL = "DELETE FROM HOTEL WHERE HOTEL_ID = ?";
	
	// RoomBookingDaoImpl

	// RoomDaoImpl
	public static final String ADDNEWROOM = "INSERT INTO ROOM(ROOM_NUMBER,HOTEL_ID,ROOM_DESCRIPTION) VALUES (?,?,?)";
	public static final String REMOVEROOM = "DELETE FROM ROOM WHERE ROOM_ID = ?";

}

package com.accolite.sleeppods.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accolite.sleeppods.dao.AdminActionsDao;
import com.accolite.sleeppods.dao.CrewMemberDao;
import com.accolite.sleeppods.dao.HotelDao;
import com.accolite.sleeppods.dao.ReportsDao;
import com.accolite.sleeppods.dao.RoomBookingDao;
import com.accolite.sleeppods.dao.RoomDao;
import com.accolite.sleeppods.daoimpl.AdminActionsDaoImpl;
import com.accolite.sleeppods.daoimpl.CrewMemberDaoImpl;
import com.accolite.sleeppods.daoimpl.HotelDaoImpl;
import com.accolite.sleeppods.daoimpl.ReportsDaoImpl;
import com.accolite.sleeppods.daoimpl.RoomBookingDaoImpl;
import com.accolite.sleeppods.daoimpl.RoomDaoImpl;

@Configuration
public class DaoBeans {

	@Bean(autowire = Autowire.BY_TYPE)
	public AdminActionsDao adminActionsDao() {
		return new AdminActionsDaoImpl();
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public CrewMemberDao crewMemberDao() {
		return new CrewMemberDaoImpl();
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public HotelDao hotelDao() {
		return new HotelDaoImpl();
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public RoomDao roomDao() {
		return new RoomDaoImpl();
	}
	
	@Bean(autowire=Autowire.BY_TYPE)
	public RoomBookingDao roomBookingDao() {
		return new RoomBookingDaoImpl();
	}
	
	@Bean(autowire=Autowire.BY_TYPE)
	public ReportsDao reportsDao() {
		return new ReportsDaoImpl();
	}
}

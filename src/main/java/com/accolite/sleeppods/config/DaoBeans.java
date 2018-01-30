package com.accolite.sleeppods.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accolite.sleeppods.dao.CrewMemberDao;
import com.accolite.sleeppods.dao.HotelDao;
import com.accolite.sleeppods.daoimpl.CrewMemberDaoImpl;
import com.accolite.sleeppods.daoimpl.HotelDaoImpl;

@Configuration
public class DaoBeans {

	@Bean(autowire=Autowire.BY_TYPE)
	public HotelDao hotelDao() {
		return new HotelDaoImpl();
	}
	
	@Bean(autowire=Autowire.BY_TYPE)
	public CrewMemberDao crewMemberDao() {
		return new CrewMemberDaoImpl();
	}
}

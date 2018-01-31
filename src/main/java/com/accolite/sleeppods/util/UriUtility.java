package com.accolite.sleeppods.util;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UriUtility {

	private static final Logger logger = Logger.getLogger(UriUtility.class);

	JdbcTemplate jdbcTemplate;

	@Async
	public void createURI(Integer id, String uri) {
		// TODO 
//		String deleteOld;
//		String sql;
//		if (userType == UserType.ADMIN) {
//			deleteOld = "DELETE FROM ADMIN_PASSWORD_URI WHERE ADMIN_ID=?";
//			sql = "INSERT INTO ADMIN_PASSWORD_URI(ADMIN_ID,URI) VALUES(?,?)";
//		} else {
//			deleteOld = "DELETE FROM USER_PASSWORD_URI WHERE USER_ID=?";
//			sql = "INSERT INTO USER_PASSWORD_URI(USER_ID,URI) VALUES(?,?)";
//		}
//		try {
//			jdbcTemplate.update(deleteOld, id);
//			jdbcTemplate.update(sql, id, uri);
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Exception", e);
//		}
	}

	@Async
	public void deleteURI(String uri) {
		// TODO
//		String sql;
//		if (userType == UserType.ADMIN) {
//			sql = "DELETE FROM ADMIN_PASSWORD_URI WHERE URI=?";
//		} else {
//			sql = "DELETE FROM USER_PASSWORD_URI WHERE URI=?";
//		}
//		jdbcTemplate.update(sql, uri);
	}

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
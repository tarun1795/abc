package com.accolite.sleeppods.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.sleeppods.model.CrewMember;
import com.accolite.sleeppods.util.CrewType;

public class CrewMemberMapper implements RowMapper<CrewMember> {

	private final Logger logger = Logger.getLogger(CrewMemberMapper.class);

	@Override
	public CrewMember mapRow(ResultSet rs, int rowNum) throws SQLException {
		CrewMember member = new CrewMember();
		try {
			member.setId(rs.getInt("CREW_ID"));
			member.setName(rs.getString("CREW_NAME"));
			member.setEmail(rs.getString("CREW_EMAIL"));
			member.setPhone(rs.getString("CREW_PHONE"));
			member.setCrewType(CrewType.valueOf(rs.getString("CREW_TYPE_NAME")));
			member.setEnabled((rs.getString("ENABLED").equals("Y")) ? true : false);
		} catch (SQLException e) {
			logger.error(e);
		}
		return member;
	}

}

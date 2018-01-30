package com.accolite.sleeppods.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.sleeppods.dao.CrewMemberDao;
import com.accolite.sleeppods.mapper.CrewMemberMapper;
import com.accolite.sleeppods.model.CrewMember;

public class CrewMemberDaoImpl implements CrewMemberDao {

	private final Logger logger = Logger.getLogger(CrewMemberDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean createCrewMember(CrewMember member) {
		String createCrewMember = "INSERT INTO CREW_MEMBER (CREW_NAME,CREW_EMAIL,CREW_PHONE,CREW_TYPE_ID) VALUES (?,?,?,(SELECT CREW_TYPE_ID FROM CREW_TYPE WHERE CREW_TYPE_NAME = ?))";
		int affectedRows;
		try {
			logger.debug(member.getCrewType().toString());
			affectedRows = jdbcTemplate.update(createCrewMember, member.getName(), member.getEmail(), member.getPhone(),
					member.getCrewType().toString());
		} catch (Exception e) {
			logger.error("Cannot create crew member " + member, e);
			affectedRows = 0;
		}
		return (affectedRows > 0);
	}

	@Override
	public boolean enableCrewMember(int memberId) {
		String disableCrewMember = "UPDATE CREW_MEMBER SET ENABLED = 'Y' WHERE CREW_ID = ?";
		int rowsAffected;
		try {
			rowsAffected = jdbcTemplate.update(disableCrewMember, memberId);
		} catch (Exception e) {
			logger.error("Cannot disable Crew Member with id " + memberId);
			rowsAffected = 0;
		}
		return (rowsAffected > 0);
	}

	@Override
	public boolean disableCrewMember(int memberId) {
		String disableCrewMember = "UPDATE CREW_MEMBER SET ENABLED = 'N' WHERE CREW_ID = ?";
		int rowsAffected;
		try {
			rowsAffected = jdbcTemplate.update(disableCrewMember, memberId);
		} catch (Exception e) {
			logger.error("Cannot disable Crew Member with id " + memberId);
			rowsAffected = 0;
		}
		return (rowsAffected > 0);
	}

	@Override
	public List<CrewMember> getAllCrewMembers() {
		String getAllCrewMembers = "SELECT * FROM CREW_MEMBER JOIN CREW_TYPE ON CREW_TYPE.CREW_TYPE_ID = CREW_MEMBER.CREW_TYPE_ID";
		try {
			return jdbcTemplate.query(getAllCrewMembers, new CrewMemberMapper());
		} catch(Exception e) {
			logger.error("Error getting all crew members",e);
		}
		return new ArrayList<>();
	}

	@Override
	public CrewMember getCrewDetails(int memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCrewMember(int memberId) {
		// TODO Auto-generated method stub
		return false;
	}

}

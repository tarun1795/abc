package com.accolite.sleeppods.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.sleeppods.dao.CrewMemberDao;
import com.accolite.sleeppods.mapper.CrewMemberMapper;
import com.accolite.sleeppods.model.CrewMember;
import com.accolite.sleeppods.util.Query;

public class CrewMemberDaoImpl implements CrewMemberDao {

	private final Logger logger = Logger.getLogger(CrewMemberDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean createCrewMember(CrewMember member) {
		int affectedRows;
		try {
			logger.debug(member.getCrewType().toString());
			affectedRows = jdbcTemplate.update(Query.CREATECREWMEMBER, member.getName(), member.getEmail(), member.getPhone(),
					member.getCrewType().toString());
		} catch (Exception e) {
			logger.error("Cannot create crew member " + member, e);
			affectedRows = 0;
		}
		return (affectedRows > 0);
	}

	@Override
	public boolean disableCrewMember(int memberId) {
		int rowsAffected;
		try {
			rowsAffected = jdbcTemplate.update(Query.DISABLECREWMEMBER, memberId);
		} catch (Exception e) {
			logger.error("Cannot disable Crew Member with id " + memberId);
			rowsAffected = 0;
		}
		return (rowsAffected > 0);
	}

	@Override
	public boolean enableCrewMember(int memberId) {
		int rowsAffected;
		try {
			rowsAffected = jdbcTemplate.update(Query.ENABLECREWMEMBER, memberId);
		} catch (Exception e) {
			logger.error("Cannot disable Crew Member with id " + memberId);
			rowsAffected = 0;
		}
		return (rowsAffected > 0);
	}

	@Override
	public List<CrewMember> getAllCrewMembers() {
		try {
			return jdbcTemplate.query(Query.GETALLCREWMEMBERS, new CrewMemberMapper());
		} catch (Exception e) {
			logger.error("Error getting all crew members", e);
		}
		return new ArrayList<>();
	}

	@Override
	public CrewMember getCrewDetails(int memberId) {
		try {
			return jdbcTemplate.queryForObject(Query.GETCREWDETAILS, new Object[] { memberId }, new CrewMemberMapper());
		} catch (Exception e) {
			logger.error("Error getting crew member with id " + memberId, e);
		}
		return null;
	}

	@Override
	public boolean removeCrewMember(int memberId) {
		int affectedRows;
		try {
			affectedRows = jdbcTemplate.update(Query.REMOVECREWMEMBER, memberId);
		}catch(Exception e) {
			logger.error("Error deleting crew member with id "+memberId);
			affectedRows = 0;
		}
		return (affectedRows>0);
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

}

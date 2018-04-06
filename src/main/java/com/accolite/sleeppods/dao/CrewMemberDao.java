package com.accolite.sleeppods.dao;

import java.util.List;

import javax.sql.DataSource;

import com.accolite.sleeppods.model.CrewMember;

public interface CrewMemberDao {

	public boolean createCrewMember(CrewMember member);
	public boolean disableCrewMember(int memberId);
	public boolean enableCrewMember(int memberId);
	public List<CrewMember> getAllCrewMembers();
	public CrewMember getCrewDetails(String emailId);
	public boolean removeCrewMember(int memberId);
	public void setDataSource(DataSource dataSource);
}

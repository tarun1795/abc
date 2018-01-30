package com.accolite.sleeppods.dao;

import java.util.List;

import javax.sql.DataSource;

import com.accolite.sleeppods.model.CrewMember;

public interface CrewMemberDao {

	public void setDataSource(DataSource dataSource);
	public boolean createCrewMember(CrewMember member);
	public boolean enableCrewMember(int memberId);
	public boolean disableCrewMember(int memberId);
	public List<CrewMember> getAllCrewMembers();
	public CrewMember getCrewDetails(int memberId);
	public boolean removeCrewMember(int memberId);
}

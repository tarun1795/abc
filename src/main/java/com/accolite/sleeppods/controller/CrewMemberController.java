package com.accolite.sleeppods.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.sleeppods.dao.CrewMemberDao;
import com.accolite.sleeppods.exception.BadRequestException;
import com.accolite.sleeppods.model.CrewMember;
import com.accolite.sleeppods.util.UriUtility;

@RestController
@RequestMapping("/crew")
public class CrewMemberController {

	private final Logger logger = Logger.getLogger(CrewMemberController.class);
	
	@Autowired
	CrewMemberDao crewMemberDao; 
	
	@Autowired
	UriUtility uriUtil;

	@PostMapping
	public void addNewCrewMember(@RequestBody CrewMember member) {
		boolean isDone = crewMemberDao.createCrewMember(member);
		if(!isDone) {
			throw new BadRequestException("Cannot create member "+member.getName());
		}
		logger.info("Crew member "+member.getName()+" created");
		// TODO send password mail
	}
	
	@PutMapping("{memberId}/{action}")
	public void enableCrewMember(@PathVariable String action,@PathVariable int memberId) {
		boolean isDone = false;
		switch(action) {
		case "enable":
			isDone = crewMemberDao.enableCrewMember(memberId);
			break;
		case "disable":
			isDone = crewMemberDao.disableCrewMember(memberId);
			break;
		default:
			throw new BadRequestException("Wrong action!");
		}
		if(!isDone) {
			throw new BadRequestException("Cannot "+action+" crew member with id "+memberId);
		}
		logger.info("Did "+action+" - Crew Member id "+memberId);
	}
	
	@GetMapping("all")
	public List<CrewMember> getAllCrewMembers() {
		List<CrewMember> members = crewMemberDao.getAllCrewMembers();
		if(members.isEmpty()) {
			throw new BadRequestException("Cannot get all crew members");
		}
		logger.info("Returning list of all Crew members");
		return members;
	}
	
	@GetMapping("{memberId}")
	public CrewMember getCrewDetails(@PathVariable int memberId) {
		CrewMember member = crewMemberDao.getCrewDetails(memberId);
		if(member == null) {
			throw new BadRequestException("Error getting details of crew member with id "+memberId);
		}
		logger.info("Returning details of crew member with id "+memberId);
		return member;
	}
	
	@DeleteMapping("{memberId}")
	public void removeCrew(@PathVariable int memberId) {
		boolean isDone = crewMemberDao.removeCrewMember(memberId);
		if(!isDone) {
			throw new BadRequestException("Error deleting crew member with id "+memberId);
		}
		logger.info("Deleted crew member with id "+memberId);
	}
}

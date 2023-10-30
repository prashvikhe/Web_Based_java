package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao 
{
	String addTeam(Team team);
	List<Team> getAllTeams();
	Team getTeamDetails(long teamId);
}

package DAO;

import java.sql.SQLException;
import java.util.List;

import POJOS.Team;

public interface DAOTeam 
{
	public List<Team> teamList() throws SQLException;
}

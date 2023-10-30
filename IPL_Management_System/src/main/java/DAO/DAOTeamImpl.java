package DAO;

import static DB.DBConnection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJOS.Team;

public class DAOTeamImpl implements DAOTeam 
{
	Connection con;
	PreparedStatement pst1,pst2;
	public DAOTeamImpl() throws SQLException
	{
		con=openConnection();
		pst1=con.prepareStatement("select * from teams");
	}
	
	@Override
	public List<Team> teamList() throws SQLException 
	{
		ArrayList<Team> list=new  ArrayList<Team>();
		try(ResultSet set=pst1.executeQuery())
		{
			while(set.next())
			{
				list.add(new Team(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getInt(5),set.getInt(6),set.getInt(7)));
			}
			return list;
		} 

	}

}

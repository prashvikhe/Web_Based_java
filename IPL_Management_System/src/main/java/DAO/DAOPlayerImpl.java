package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static DB.DBConnection.*;

import POJOS.Players;

public class DAOPlayerImpl implements DAOPlayerI
{
	Connection con;
	PreparedStatement pst1,pst2;
	public DAOPlayerImpl()
	{
		try 
		{
			con=openConnection();
			pst1=con.prepareStatement("insert into players values(default,?,?,?,?,?,?)");
			pst2=con.prepareStatement("select max_age,batting_avg,wickets_taken from teams where name=?");
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String addPlayer(Players player) throws SQLException 
	{
		//String name, LocalDate dob, double batavg, int wickets, String team
		pst1.setString(1, player.getFirst_name());
		pst1.setString(2, player.getLast_name());
		pst1.setDate(3, Date.valueOf(player.getDob()));
		pst1.setDouble(4,player.getBatavg());
		pst1.setInt(5,player.getWickets());
		pst1.setInt(6, player.getTeam());
		boolean b=pst1.execute();
		if(b)
		{
			return "<h1>You are selected in"+player.getTeam()+"</h1>";
		}
		else
		{
			return "<h1>You are rejected .....<a href='index.html'>Go to login</a></h1>";
		}

	}
	
	public boolean authenticatePlayer(Players player) throws SQLException
	{
		int max_age=0,batting_avg=0,wickets_taken=0;
		player.getTeam();
		pst2.setInt(1, player.getTeam());
		try(ResultSet set=pst2.executeQuery())
		{
			while(set.next())
			{
				max_age=set.getInt(1);
				batting_avg=set.getInt(2);
				wickets_taken=set.getInt(3);
			}
			if(player.getDob().getYear()>max_age && batting_avg<=player.getBatavg() && wickets_taken<=player.getWickets())
			{
				return false;
			}
			return true;
		}
		
		
		
	}
	

}

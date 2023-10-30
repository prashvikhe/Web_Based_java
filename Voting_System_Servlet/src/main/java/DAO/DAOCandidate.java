package DAO;

import static DB.DBConnection.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.xdevapi.Statement;

import POJOS.Candidate;

public class DAOCandidate implements DAOCanI
{
	Connection con;
	PreparedStatement pst1,pst2,pst3,pst4;
	public DAOCandidate() throws SQLException
	{
		con=openConnection();
		pst1=con.prepareStatement("select * from candidates");
		pst2=con.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3=con.prepareStatement(" select party,sum(votes) as votes from candidates group by party order by votes desc");
		pst4=con.prepareStatement("select party,sum(votes) as votes from candidates group by party order by votes desc limit 3;");
	}
	@Override
	public List<Candidate> getAllCandidates() throws SQLException 
	{
		List<Candidate> candidates = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
			{
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
				
		}
		return candidates;
	}

	@Override
	public String incrementCandidateVotes(int candidateId) throws SQLException 
	{
		pst2.setInt(1,candidateId);
		int i=pst2.executeUpdate();
		if(i==1)
		{
			return "<h1>Status Updated</h1>";
		}
		else
		{
			return "<h1>Status not updated</h1>";
		}
	}
	
	public Map<String,Integer> votingList() throws SQLException
	{
		Map<String,Integer> map=new HashMap<String, Integer>();
		ResultSet list=pst3.executeQuery();
		
		while(list.next())
		{
			map.put(list.getString(1),list.getInt(2));
		}
		return map;
	}
	
	public Map<String,Integer> resultList() throws SQLException
	{
		Map<String,Integer> map=new HashMap<String, Integer>();
		ResultSet list=pst4.executeQuery();
		
		while(list.next())
		{
			map.put(list.getString(1),list.getInt(2));
		}
		return map;
	}
	

}

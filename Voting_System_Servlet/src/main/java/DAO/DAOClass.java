package DAO;

import static DB.DBConnection.openConnection;
import static DB.DBConnection.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import POJOS.Users;

public class DAOClass implements DAOI 
{
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;
	public DAOClass() throws SQLException
	{
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		pst2=cn.prepareStatement("update users set status=1 where id=?");
		pst3=cn.prepareStatement("delete from users where email=? and password=?");
		System.out.println("user dao created!");
	}
	static ArrayList<Users> list=new ArrayList<Users>();
	{
		try(Connection con=openConnection();
				Statement st=con.createStatement())		
		{
			ResultSet rs=st.executeQuery("select * from users");
			while(rs.next())
			{
				list.add(new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toString(),rs.getInt(7),rs.getString(8)));
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	@Override
	public ArrayList<Users> userLists() throws SQLException 
	{
		return list;
	}

	@Override
	public void addUser(Users user) throws SQLException 
	{
		try(
				Connection con=openConnection();
				PreparedStatement pst=con.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)"))		
		{
			pst.setInt(1, user.getId());
			pst.setString(2, user.getFirst_Name());
			pst.setString(3, user.getLast_name());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPassword());
			pst.setDate(6,  Date.valueOf((user.getDob()).toString()));
			pst.setInt(7, user.getStatus());
			pst.setString(8, user.getRole());
			pst.executeUpdate();
		}		
	}

	@Override
	public Users authenticateUser(String email, String password) throws SQLException 
	{
		pst1.setString(1, email);		
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery()) 
		{
			if(rst.next()) 
			{
				return new Users(rst.getInt(1), rst.getString(2), rst.getString(3), email, password,rst.getDate(6).toString(), rst.getInt(7), rst.getString(8));
			}
				
		}
		return null;
	}

	public boolean deleteUser(String email,String password) throws SQLException
	{
		
			pst3.setString(1,email);
			pst3.setString(2, password);
			boolean i=pst3.execute();
			if(i)
			{
				System.out.println("User deleted succefully !!!");
			}
			else
			{
				System.out.println("User not found");
			}

		return false;
		
	}
	public void updateVotingStatus(int id) throws SQLException
	{
			pst2.setInt(1, id);
			int n=pst2.executeUpdate();
			if(n==1)
			{
				System.out.println("Status change successfully....");
			}
			else			
			{
				System.out.println("Status not changed....");
			}
		
	}

	@Override
	public boolean updateUser(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}





}

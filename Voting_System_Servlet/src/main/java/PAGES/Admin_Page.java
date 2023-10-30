package PAGES;

import static DB.DBConnection.closeConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOCandidate;
import DAO.DAOClass;
import DB.DBConnection;
import POJOS.Users;

@WebServlet("/admin")
public class Admin_Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOClass dao;
	private DBConnection con; 
	private ArrayList<Users> userList;
	


	@Override
	public void init() throws ServletException 
	{
		try {
			con.openConnection();
			dao=new DAOClass();
		} 
		catch (SQLException e) 
		{
			throw new ServletException("Connection failed in list",e);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			
			pw.write("<center><h1>Voting List</h1>");
			pw.write("<table border='2px'><thead><th>Id</th><th>First_Name</th><th>Last_Name</th><th>Date Of Birth</th><th>Email</th><th>Status</th><th>Role</th></thead>");
			userList=dao.userLists();
			pw.write("<thead>");
			userList.forEach((key)->pw.write("<tr><td>"+key.getId()+"</td><td>"+key.getFirst_Name()+"</td><td>"+key.getLast_name()+"</td><td>"+key.getDob()+"</td><td>"+key.getEmail()+"</td><td>"+key.getStatus()+"</td><td>"+key.getRole()+"</td></tr>"));
			pw.write("</thead>");
			pw.write("</table></center>");
			pw.write("<h3><a href='result'>Results</a></h3><br>");
			pw.write("<h3><a href='voting_list'>Voting_list</a></h3>");
			pw.write("</center>");
		} catch (SQLException e) 
		{
			throw new ServletException("Userlist not found",e);
		}
	}
	@Override
	public void destroy() 
	{
		try
		{
			closeConnection();
		}
		catch(Exception e)
		{
			System.out.println("Connection not closed "+e.getMessage());
		}
	}

}

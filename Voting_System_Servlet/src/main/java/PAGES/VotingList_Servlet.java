package PAGES;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOCandidate;
import DB.DBConnection;

@WebServlet("/voting_list")
public class VotingList_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOCandidate dao;
	private DBConnection con; 
	Map<String,Integer> voterList;

	@Override
	public void init() throws ServletException 
	{
		try {
			con.openConnection();
			dao=new DAOCandidate();
		} 
		catch (SQLException e) 
		{
			throw new ServletException("Connection failed in list",e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.write("<center><h1>Voting List</h1>");
			pw.write("<table border=2px><thead><th>Party</th><th>No. of Votes</th></thead>");
			voterList=dao.votingList();
			pw.write("<thead>");
			voterList.forEach((key,value)->pw.write("<tr><td>"+key+"</td><td>"+value+"</td></tr>"));
			pw.write("</thead>");
			pw.write("</table></center>");
		} 
		catch (SQLException e)
		{
			throw new ServletException("Voter list not found  ",e);
		}
	}

	@Override
	public void destroy() 
	{
		
			try 
			{
				con.closeConnection();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		
		
	}

	
}

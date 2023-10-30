package PAGES;

import static DB.DBConnection.closeConnection;
import static DB.DBConnection.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOPlayerImpl;
import POJOS.Players;

@WebServlet("/login")
public class login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Players player;
	private DAOPlayerImpl dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		try 
		{
			con=openConnection();
			dao=new DAOPlayerImpl();
		} 
		catch (SQLException e) 
		{
			throw new ServletException("Connection not Found ...",e);
		}
	}


	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			int team=Integer.parseInt(request.getParameter("team"));
			String first_name=request.getParameter("first-name");
			String last_name=request.getParameter("last-name");
			LocalDate dob=LocalDate.parse(request.getParameter("dob").toString());
			int batavg=Integer.parseInt(request.getParameter("batavg"));
			int wickets=Integer.parseInt(request.getParameter("wicket"));
			player=new Players(first_name,last_name,dob,batavg,wickets,team);
			System.out.println(player);
			boolean check=dao.authenticatePlayer(player);
			dao.addPlayer(player);
			System.out.println(check);
			if(!check)
			{
				pw.write("<h1>You are  selected in team. Congratulation "+player.getFirst_name()+" "+player.getLast_name()+".....</h1>");
			}
			else
			{
				pw.write("<h1>You are rejected.....<a href='login.html'>GO to login page</a></h1>");
			}
			
			
			
			
		} catch (SQLException e) 
		{
			throw new ServletException("Pplayer not added ...",e);
		}

	}
	
	
	@Override
	public void destroy() 
	{
		try
		{
			closeConnection();
		} 
		catch (SQLException e)
		{
			System.out.println("Connection not closed ....."+e);
		}
	}


}

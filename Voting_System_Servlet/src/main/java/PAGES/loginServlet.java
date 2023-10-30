package PAGES;
import static DB.DBConnection.closeConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOCandidate;
import  DAO.DAOClass;
import POJOS.Users;
import POJOS.*;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOClass dao;
    private DAOCandidate daocan;

    @Override
	public void init() throws ServletException 
    {
		try
		{
			dao=new DAOClass();
			daocan=new DAOCandidate();
		}
		catch(Exception e)
		{
			throw new ServletException("Connection not found "+e.getMessage());
		}
	}
     
    
	

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			Users user=dao.authenticateUser(email,password);
			System.out.println(user);
			if(user==null)
			{
				pw.write("<h1>User not Found. Please <a href='login.html'>Retry</a> </h1>");
//				pw.close();
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("user",user );
				session.setAttribute("dao",dao);
				session.setAttribute("daocan", daocan);
				System.out.println(user.getStatus());
	//			pw.write(user.toString());
				if(user.getRole().equals("admin"))
				{
	//				Cookie cookies=new Cookie("data", user.toString());
					
					response.sendRedirect("admin");
				}
				else if(user.getStatus()==0)
				{
					
	//					Cookie cookies=new Cookie("data",user.toString());
	//					response.addCookie(cookies);
						System.out.println("status");
						response.sendRedirect("candidate");
					}
					else	
					{
						response.sendRedirect("logout");
					}
				}
		}
				
		catch (Exception e) 
		{
			throw new ServletException("Error in do get "+e.getMessage());
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

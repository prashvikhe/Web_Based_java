package PAGES;

import POJOS.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import DAO.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOClass;

@WebServlet("/register")
public class Registration_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOClass dao;
	Users user;
	@Override
	public void init() throws ServletException 
	{
		try 
		{
			dao=new DAOClass();
		} catch (SQLException e) 
		{
			throw new ServletException("<h1>Not registered </h1>");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			 int id=Integer.valueOf(request.getParameter("id"));
			 String first_Name=request.getParameter("firstname");
			 String last_name=request.getParameter("lastname");
			 String email=request.getParameter("email");
			 String password=request.getParameter("password");
//			 String conPassword=request.getParameter("con-password");
			 String dob=request.getParameter("dob");
			 String dob1=(LocalDate.now().getYear()-LocalDate.parse(dob).getYear())>21?dob:"<h1>Age is not match</h1>";	 
			 int status=Integer.valueOf(request.getParameter("status"));;
			 String role=request.getParameter("role");
			 if(!dob1.equals(dob))
			 {
				 pw.write(dob1);
				 pw.close();
			 }
//			 if(password!=(conPassword))
//			 {
//				 pw.write("<h1>Password not match</h1>");
//				 pw.close();
//			 }
			 user=new Users(id,first_Name,last_name,email,password,dob,status,role);
			 dao.addUser(user);
			 pw.write("<h1>User added Successfully  !!!!<br><a href='login.html'>Go to Login Page</a></h1>");
		} catch (Exception e) 
		{
			throw new ServletException("<h1>REgister not work properly </h1>");
		}
	}


	
}

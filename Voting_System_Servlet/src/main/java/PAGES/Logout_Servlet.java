package PAGES;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOCandidate;
import DAO.DAOClass;
import POJOS.Users;


@WebServlet("/logout")
public class Logout_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			HttpSession session=request.getSession();
			Users user=(Users)session.getAttribute("user");
			
			System.out.println(user);
			if(user.getStatus()==0)
			{	
				DAOClass dao=(DAOClass)session.getAttribute("dao");
				DAOCandidate daocan=(DAOCandidate)session.getAttribute("daocan");
				int cadidateID=Integer.parseInt(request.getParameter("candidates"));
				dao.updateVotingStatus(user.getId());
				System.out.println(daocan);
				System.out.println("asd"+cadidateID);
				pw.print("<h5>"+daocan.incrementCandidateVotes(cadidateID)+"</h5>");
				System.out.println("asd");

			}
			else
			{
				pw.write("<h1>You have already voted</h1>");
			}
		}
		catch (SQLException e) 
		{
			throw new ServletException("<h1>Logout unsuccessfully</h1>"+e.getMessage(),e);
		}
	}

}

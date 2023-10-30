package PAGES;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOCandidate;
import DAO.DAOClass;
import POJOS.*;
import POJOS.Candidate;

@WebServlet("/candidate")
public class Candidate_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	response.setContentType("text/html");
	try (PrintWriter pw = response.getWriter()) 
	{
		HttpSession session = request.getSession();
		System.out.println(session.isNew());
		System.out.println(session.getId());
		Users user=(Users)session.getAttribute("user");
//		DAOClass dao=(DAOClass)session.getAttribute("dao");
		DAOCandidate daocan=(DAOCandidate)session.getAttribute("daocan");
		if(user!=null)
		{
			System.out.println();
			pw.print("<h1> Hello , " + user.getFirst_Name()+ " " + user.getLast_name() + "</h1>");
			List<Candidate> candidate=daocan.getAllCandidates();
			pw.write("<h1>Select Candidate : </h1>");
			pw.write("<form action='logout'>");
			for(Candidate c:candidate)
			{
				pw.write("<input type='radio' name='candidates' value="+c.getCandidateId()+">"+c.getName()+"</input><br>");
			}
			pw.write("<input type='submit'  value='Submit Voter'></input>");
			pw.write("</form>");
		}
	} 
	catch (SQLException e) 
	{
		throw new ServletException("<h1>Do get not worked in Candidate page</h1>");
	}
}

}

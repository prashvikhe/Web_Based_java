package Tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDaoImpl;
import pojos.Team;

public class AddNewTeam 
{
	static TeamDaoImpl tdao;
	public static void main(String[] args) 
	{
		tdao=new TeamDaoImpl();
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter  name,  abbreviation,  owner,  maxAge,  battingAvg,  wicketsTaken");
			String msg=tdao.addTeam(new Team(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

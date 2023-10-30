package Tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.PlayerDaoImpl;
import pojos.Player;
import pojos.Team;

public class AddPlayerInTeam 
{
	
	static PlayerDaoImpl  playerDao;
	public static void main(String[] args) 
	{
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in))
		{
			playerDao=new PlayerDaoImpl();
			System.out.println("Enter a details :  firstName,  lastName,email, dob,  battingAvg,  wicketsTaken");
			Player player=new Player(sc.next(),sc.next(),sc.next(),LocalDate.parse(sc.next()),sc.nextInt(),sc.nextInt());
			System.out.println("enter a team_id");
			String msg=playerDao.addPlayer(player,sc.nextLong());
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

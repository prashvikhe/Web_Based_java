package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Team;
import utils.HibernateUtils;

class TestTeamDao {

	private static TeamDao dao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		//build SF n create dao instance 
		HibernateUtils.getFactory();//triggers the creation of SFs 
		dao=new TeamDaoImpl(); 
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		HibernateUtils.getFactory().close();;
	}

	@Test
	void test() {
		//create team instance hard coded details
		//invoke dao's method
		//assert if id=1
		//Team("Gujrat Titans","GT","Owner3",40,50,15);
		Team newteam=new Team("Mumbai Indians","MI","Owner1",60,80,15);
		String msg=dao.addTeam(newteam);
		System.out.println(msg);
		assertEquals(2, newteam.getId());
	}
	@Test
	void testGetAllTeams()
	{
		dao=new TeamDaoImpl();
		List<Team> teams=dao.getAllTeams();
//		System.out.println(teams);
		teams.forEach(p->System.out.println(p.getId()+" "+p.getAbbreviation()));
	}

}

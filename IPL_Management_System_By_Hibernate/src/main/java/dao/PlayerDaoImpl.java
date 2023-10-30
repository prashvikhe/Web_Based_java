package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImpl implements PlayerDao
{

	@Override
	public String addPlayer(Player player,Long teamId) {
		String msg="Player not added ....";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		Team team=session.get(Team.class, teamId);
		System.out.println(player);
		try
		{
			team.addPlayer(player);
			session.persist(player);

			tx.commit();
			msg="Player added successfully....";
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		return msg;
	}

	@Override
	public List<Player> playerDetails() 
	{
		List<Player> list=null;
		
		String jpql="Select p from Player ";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try
		{
			list=session.createQuery(jpql,Player.class).getResultList();
			tx.commit();
			
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		return list;
	}
	
	
	

}

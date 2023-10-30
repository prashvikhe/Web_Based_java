package dao;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;

public class TeamDaoImpl implements TeamDao
{
	@Override
	public String addTeam(Team team) 
	{
		String msg="Team not added ....";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try
		{
			session.persist(team);
			tx.commit();
			msg="Team added successfully....";
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
	public List<Team> getAllTeams() 
	{
		List<Team> list=null;
		String jpql="Select new pojos.Team(id,abbreviation) from Team";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try
		{
			list=session.createQuery(jpql,Team.class).getResultList();
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

	@Override
	public Team getTeamDetails(long teamId) 
	{
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		Team team=null; 
		try
		{
			team=session.get(Team.class,teamId);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		return team;
	}
	
}

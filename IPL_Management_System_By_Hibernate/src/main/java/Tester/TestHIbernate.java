package Tester;

import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;
public class TestHIbernate 
{
	public static void main(String[] args) {
		try(SessionFactory sf=getFactory())
		{
			System.out.println("In session factory");
		}
	}
}

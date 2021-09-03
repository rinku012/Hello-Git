package in.co.rays.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class Testuser {

	public static void main(String[] args) {
		testmarge();
		// testadd();
		// testdelete();
		// testupdate();
		// testget();
		// testselect();
		// testgetonerecord();
		// testgetmultirecord();
		// testcriteria();
		// testcriteriaproandres();
	}

	public static void testmarge() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		User u = (User) s.get(User.class, 1);

		System.out.println(u.getFname());

		s.close();

		
		  u.setFname("Sahil"); Session s1 = sessionFactory.openSession();
		  
		  Transaction tx =s1.beginTransaction(); s1.merge(u);
		  
		  tx.commit(); s1.close();
		 

	}

	public static void testcriteriaproandres() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Criteria cr = s.createCriteria(User.class);

		cr.addOrder(Order.asc("fname"));

		List list = cr.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			int u = (int) it.next();
			System.out.println("fname");

		}

	}

	public static void testcriteria() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();// firstlavel

		Criteria cr = s.createCriteria(User.class);

		ProjectionList pL = Projections.projectionList();

		pL.add(Projections.count("id"));

		cr.setProjection(pL);

		List list = cr.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			int u = (Integer) it.next();

			System.out.println(u);

		}
	}

	public static void testgetmultirecord() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Query query = s.createQuery("slect u.id,u.fname from User ");

		User u;

		List Rows = query.list();

		Iterator it = Rows.iterator();

		Object[] columns;

		System.out.println();
	}

	public static void testselect() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Query query = s.createQuery("select count(*) from User");

		List list = query.list();

		Iterator it = list.iterator();

		User u;

		while (it.hasNext()) {
			u = (User) it.next();

			System.out.println(u.getId() + " " + u.getFname() + " " + u.getLname() + " " + u.getUsername() + " "
					+ u.getPassword());
		}
	}

	public static void testgetonerecord() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Query query = s.createQuery("from User where fname like 'R%' order by fname ");

		List list = query.list();

		Iterator it = list.iterator();

		User u;

		while (it.hasNext()) {
			u = (User) it.next();

			System.out.println(u.getFname());
		}
	}

	public static void testget() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		User u = (User) s.get(User.class, 5);

		System.out.println(u.getId());
		System.out.println(u.getFname());
		System.out.println(u.getLname());
		System.out.println(u.getUsername());
		System.out.println(u.getPassword());

	}

	public static void testupdate() {

		User u = new User();

		u.setId(6);
		u.setFname("YASH");
		u.setLname("SHARMA");
		u.setUsername("YS.SHARMA");
		u.setPassword("9876");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.update(u);

		tx.commit();
		s.close();
		System.out.println("update");

	}

	public static void testdelete() {

		User u = new User();

		u.setId(7);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.delete(u);

		tx.commit();
		s.close();
		System.out.println("deleted");

	}

	public static void testadd() {

		User u = new User();
		u.setFname("NAVIN");
		u.setLname("GAVDE");
		u.setUsername("NG.GAVDE");
		u.setPassword("9898");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(u);

		tx.commit();
		s.close();

		System.out.println("inserted");

	}

}

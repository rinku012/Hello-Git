package in.com.association;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestEmployee {

	public static void main(String[] args) {
		
		testadd();

	}

	public static void testadd() {
		
		Employee empy = new Employee();
		
		empy.setFname("Umaesh");
		empy.setLname("patidar");
		
		Address empaddr = new Address();
		
		empaddr.setCity("indore");
		empaddr.setState("mp");
		
		SessionFactory sessionFactory =new Configuration().configure("association.cfg.xml").buildSessionFactory();
		
		Session s = sessionFactory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(empy);
		
		
		tx.commit();
		s.close();
		
		System.out.println("inserted");
	}		
}	
		
		
		
	



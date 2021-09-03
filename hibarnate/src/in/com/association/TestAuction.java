package in.com.association;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestAuction {

	public static void main(String[] args) {
	
	testadd();
	}
		
		public static void testadd() {
			Auction item = new Auction();

			item.setDescription("audi");
			
			
			Bid bid = new Bid();
			
			bid.setAmount(100);
					
			Set<Bid> set = new HashSet<>();
			
		      set.add(bid);
			
			item.setBids(set);
	       SessionFactory sessionFactory =new Configuration().configure("association.cfg.xml").buildSessionFactory();
			
			Session s = sessionFactory.openSession();
			
			Transaction tx = s.beginTransaction();
			
			s.save(item);
			
			
			tx.commit();
			s.close();
			
			System.out.println("inserted");
			
			

		}
		
	}

		
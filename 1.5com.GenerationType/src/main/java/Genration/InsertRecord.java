package Genration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		UserFLC user = new UserFLC();
		user.setName("Swapnil");
		user.setEmail("swapnil@gmail.com");
		user.setPhone(9876543210L);

		et.begin();
		em.persist(user);
		et.commit();
		
		System.out.println("Records Saved");
	}
}

package com.Annotation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		User user = new User();
		user.setName("Dinga");
		user.setEmail("dinag@email.com");
		user.setPhone(98765743l);
		et.begin();
		em.persist(user);
		et.commit();
		System.out.println("saved");
	}

}

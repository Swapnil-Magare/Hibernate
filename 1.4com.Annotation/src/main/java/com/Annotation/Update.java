package com.Annotation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		User user = em.find(User.class, 3);
		if (user != null) {
			user.setName("Dingii");
			em.merge(user);
			et.commit();
			System.out.println("updated");
		} else {
			System.out.println("not found");
		}
	}
}

package com.carEngine_OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Car car = em.find(Car.class, 101);
		if (car != null) {
			Engine engine = car.getEngine();
			em.remove(car);
			em.remove(engine);
			et.commit();
			System.out.println("record removed");
		} else {
			System.out.println("car does not exist");
		}
	}
}

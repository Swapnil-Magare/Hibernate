package com.carEngine_OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMargeCar {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Car car = em.find(Car.class, 101);
		if (car != null) {
			Engine engine = car.getEngine();
			car.setBrand("Volvo");
			car.setPrice(1500000);
			engine.setCc(1500);
			em.merge(car);
			em.merge(engine);
			et.commit();
		} else {
			System.out.println("car does not exist");
		}
	}
}

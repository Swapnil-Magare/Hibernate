package com.carEngine_OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertDataToCarEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car = new Car();
		car.setCid(101);
		car.setBrand("TATA");
		car.setPrice(1000000);
		
		
		Engine engine = new Engine();
		engine.setEid(111);
		engine.setCc(1000);
		
		car.setEngine(engine);
		et.begin();
		em.persist(car);
		em.persist(engine);
		et.commit();
	}
}

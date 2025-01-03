package com.carEngine_OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchAll {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Car car = em.find(Car.class, 101);
		et.commit();
		System.out.println("----------------Car----------------");
		System.out.println(car);
		System.out.println(car.getCid());
		System.out.println(car.getBrand());
		System.out.println(car.getPrice());
		Engine engine = car.getEngine();
		System.out.println("----------------Engine----------------");
		System.out.println(engine.getEid());
		System.out.println(engine.getCc());
	}
}
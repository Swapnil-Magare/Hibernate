package com.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InnsertOperation {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = new Student();
		student.setSid(02);
		student.setName("Swapnil");
		student.setEmail("magare@gmail.com");
		student.setPhone(998090766);

		et.begin();
		em.persist(student);
		et.commit();

		System.out.println("Saved");
	}

}

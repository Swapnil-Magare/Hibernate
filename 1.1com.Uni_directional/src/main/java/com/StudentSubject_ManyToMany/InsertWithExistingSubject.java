package com.StudentSubject_ManyToMany;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertWithExistingSubject {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gunsilan");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student1 s1 = new Student1();
		s1.setId(102);
		s1.setName("Dingi");

		Subject s = new Subject();
		s.setId(3);
		s.setName("SQL");
		Subject s2 = em.find(Subject.class, 1);
		Subject s3 = em.find(Subject.class, 2);
		s1.setSubjects(Arrays.asList(s, s2, s3));

		et.begin(); 	
		em.persist(s1);
		em.persist(s);
		et.commit();
		System.out.println("Saved");
	}

}

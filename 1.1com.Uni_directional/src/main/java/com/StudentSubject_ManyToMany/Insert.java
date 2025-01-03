package com.StudentSubject_ManyToMany;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gunsilan");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student1 s1 = new Student1();
		s1.setId(101);
		s1.setName("Dinga");

		Subject s = new Subject();
		s.setId(1);
		s.setName("html");

		Subject s2 = new Subject();
		s2.setId(2);
		s2.setName("Java");

		s1.setSubjects(Arrays.asList(s, s2));

		et.begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s);
		et.commit();
		System.out.println("Saved");
	}
}

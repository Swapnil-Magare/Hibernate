package com.Student;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchAllStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select s from Student s");
		List<Student> stduents = query.getResultList();
		System.out.println("*******************stduents*******************");
		for (Student student : stduents) {

			System.out.println(student.getSid());
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			System.out.println(student.getPhone());
			System.out.println("=============================");
		}
		et.commit();
	}
}

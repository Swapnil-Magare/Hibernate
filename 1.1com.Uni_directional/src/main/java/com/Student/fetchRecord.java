package com.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class fetchRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Student student = em.find(Student.class, 01);
		et.commit();
		if (student != null) {
			System.out.println("=================");
			System.out.println("Sid : " + student.getSid());
			System.out.println("Name : " + student.getName());
			System.out.println("Email : " + student.getEmail());
			System.out.println("Phone : " + student.getPhone());
			System.out.println("=================");
		} else {
			System.out.println("stduent does not exist");
		}
	}
}

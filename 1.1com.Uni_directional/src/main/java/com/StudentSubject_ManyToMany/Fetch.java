package com.StudentSubject_ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gunsilan");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Student1 student = em.find(Student1.class, 102);
		et.commit();
		if (student != null) {
			System.out.println("-------------------Student-------------------");
			System.out.println(student);
			List<Subject> subjects = student.getSubjects();
			for (Subject subject : subjects) {
				System.out.println("-------------------Subject-------------------");
				System.out.println(subject);
			}
		} else {
			System.out.println("Not Found");
		}
	}
}

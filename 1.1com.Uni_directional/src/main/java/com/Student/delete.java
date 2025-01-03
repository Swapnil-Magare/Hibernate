package com.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class delete {
	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Student student=em.find(Student.class,101);
		if(student!=null){
		em.remove(student);
		et.commit();
		System.out.println("record deleted");
		}else{
		System.out.println("student not found");
		}
		}
}

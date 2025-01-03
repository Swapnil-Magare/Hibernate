package com.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class update {
	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Student student=em.find(Student.class,103);
		if(student!=null){
			student.setPhone(675652348);
			student.setEmail("dingadingi@gmail.com");
		em.merge(student);
		et.commit();
		System.out.println("stduent updated");
		}else{
		System.out.println("student not found");
		}
		}
}

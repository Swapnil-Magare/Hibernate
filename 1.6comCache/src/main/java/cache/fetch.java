package cache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityManager em1 = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		Student std = em.find(Student.class, 1);
		System.out.println(std);
		
		Student std0 = em.find(Student.class, 1);
		System.out.println(std);
		
		Student std1 = em1.find(Student.class, 1);
		System.out.println(std1);
		
		Student std2 = em1.find(Student.class, 1);
		System.out.println(std1);
		
		


		// this is when we try to fetch the record from table.
		// wihtout using persist() and merge() it will give the error
		// because we are trying without inserting or Updating directly Removing the
		// object.
//		Student s=new Student();
//		s.setId(4);
//		em.remove(em.merge(s));
		et.commit();
		System.out.println("deleted");

	}

}

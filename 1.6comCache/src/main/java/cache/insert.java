package cache;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		// Initialize Scanner for user input
		Scanner scanner = new Scanner(System.in);
		// Prompt the user for input
		System.out.println("Enter student name:");
		String name = scanner.nextLine();

		System.out.println("Enter student email:");
		String email = scanner.nextLine();
		
		et.begin();
		Student std = new Student();
		std.setName(name);
		std.setEmail(email);
		em.persist(std);

		et.commit();

		System.out.println("saved: " + std);
		em.close();
		emf.close();
		scanner.close();

	}

}

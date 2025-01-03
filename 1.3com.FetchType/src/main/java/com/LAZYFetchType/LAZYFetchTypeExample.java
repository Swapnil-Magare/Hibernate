package com.LAZYFetchType;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LAZYFetchTypeExample {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FetchType");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		// Creating and persisting an Author with some Books
		LAZYAuthor author = new LAZYAuthor();
		author.setName("Author Name");

		LAZYBook book1 = new LAZYBook();
		book1.setTitle("Book One");
		book1.setAuthor(author);

		LAZYBook book2 = new LAZYBook();
		book2.setTitle("Book Two");
		book2.setAuthor(author);

		em.persist(author);
		em.persist(book1);
		em.persist(book2);

		// Fetching the author
		LAZYAuthor fetchedAuthor = em.find(LAZYAuthor.class, 1l);
		et.commit();
		if (fetchedAuthor != null) {
			// If FetchType is LAZY, books will only load here
			System.out.println("Author Name: " + fetchedAuthor.getName());
			System.out.println("Books: " + fetchedAuthor.getBooks());

			List<LAZYBook> book = fetchedAuthor.getBooks();
			for (LAZYBook books : book) {

				System.out.println(books.getTitle());
				System.out.println(books.getId());

			}
			em.close();
			emf.close();
		}
	}
}
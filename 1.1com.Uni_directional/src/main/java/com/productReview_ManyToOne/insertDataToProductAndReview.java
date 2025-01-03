package com.productReview_ManyToOne;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class insertDataToProductAndReview {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gunsilan");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		product product = new product();
		product.setPid(101);
		product.setName("Samsung");
		product.setPrice(19000);

		review r1 = new review();
		r1.setRid(1);
		r1.setMessage("bad");
		r1.setProduct(product);

		review r2 = new review();
		r2.setRid(2);
		r2.setMessage("good working");
		r2.setProduct(product);

		et.begin();
		em.persist(product);
		em.persist(r1);
		em.persist(r2);
		et.commit();
		System.out.println("Saved");
	}
}


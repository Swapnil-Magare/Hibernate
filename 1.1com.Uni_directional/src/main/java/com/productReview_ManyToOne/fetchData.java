package com.productReview_ManyToOne;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class fetchData {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gunsilan");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		review r1 = em.find(review.class, 1);
		if (r1 != null) {

			System.out.println("----------------------Review----------------------");
			System.out.println(r1.getRid());
			System.out.println(r1.getMessage());

			System.out.println("----------------------Product----------------------");
			product product = r1.getProduct();
			System.out.println(product.getPid());
			System.out.println(product.getName());
			System.out.println(product.getPrice());

		} else {
			System.out.println("Not Found");
		}
	}
}

package com.BankAccount_OneToMany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertInBank_Account {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bank bank = new Bank();
		bank.setId(101);
		bank.setName("HDFC");
		bank.setIFC("HDFC101");

		Account a1 = new Account();
		a1.setAccNumber(7846386871346l);
		a1.setName("Jitesh");
		a1.setPhone(9876543212l);

		Account a2 = new Account();
		a2.setAccNumber(3846386871346l);
		a2.setName("Dinesh");
		a2.setPhone(8876543212l);

		Account a3 = new Account();
		a3.setAccNumber(4846386871346l);
		a3.setName("Devendra");
		a3.setPhone(7876543212l);

		List<Account> accounts = new ArrayList<Account>();
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		bank.setAccounts(accounts);
		et.begin();
		em.persist(bank);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		et.commit();
		System.out.println("saved");
	}
}
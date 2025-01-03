package com.BankAccount_OneToMany;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchFromBank_Account {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefirst");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Bank bank = em.find(Bank.class, 101);
		et.commit();
		if (bank != null) {
			System.out.println("-------------Bank------------");
			System.out.println(bank);
//			System.out.println("Bank id: " + bank.getId());
//			System.out.println("Bank name: " + bank.getName());
//			System.out.println("Bank IFC: " + bank.getIFC());
			List<Account> accounts = bank.getAccounts();
			System.out.println("--------Accounts---------");
			for (Account account : accounts) {
				System.out.println(account);
//				System.out.println(account.getAccNumber());
//				System.out.println(account.getName());
//				System.out.println(account.getPhone());
			}
		} else {
			System.out.println("bank does not exist");
		}
	}
}

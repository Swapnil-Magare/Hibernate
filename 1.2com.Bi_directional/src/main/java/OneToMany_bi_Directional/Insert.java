package OneToMany_bi_Directional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
        // Initialize EntityManager and EntityTransaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bi_directional");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            // Start the transaction
            et.begin();

            // Create Bank entity
            Bank bank = new Bank();
            bank.setBid(1);  // Set the Bank ID
            bank.setName("Sample Bank");
            bank.setAddress("123 Bank St.");

            // Create Account entities
            Account account1 = new Account();
            account1.setAccNo(101); // Set Account Number
            account1.setName("Account 1");
            account1.setBal(1000);

            Account account2 = new Account();
            account2.setAccNo(102); // Set Account Number
            account2.setName("Account 2");
            account2.setBal(5000);

            // Associate accounts with the bank
            account1.setBank(bank);
            account2.setBank(bank);

            // Create a List of Accounts and add the accounts to it
            List<Account> accounts = new ArrayList<Account>();
            accounts.add(account1);
            accounts.add(account2);

            // Set the list of accounts to the bank
            bank.setAccount(accounts);

            // Persist the bank entity (this will also persist the associated accounts due to cascading)
            em.persist(bank);

            // Commit the transaction
            et.commit();

            System.out.println("Bank and accounts inserted successfully!");

        } catch (Exception e) {
            // Rollback the transaction in case of an error
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the EntityManager and EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}

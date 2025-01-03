package OneToMany_bi_Directional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchByBank {
    public static void main(String[] args) {
        // Initialize EntityManager and EntityTransaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bi_directional");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            // Begin transaction
            et.begin();
            
            // Fetch the bank with a specific bid (assuming bid = 1 for example)
            Bank bank = em.find(Bank.class, 1);  // Replace with the bank ID you want to search for
            et.commit();

            if (bank != null) {
                System.out.println("----------------Bank-------------------");
                System.out.println(bank);

                // Fetch the associated accounts from the Bank
                if (bank.getAccount() != null && !bank.getAccount().isEmpty()) {
                    System.out.println("-------------------Accounts-------------------");
                    for (Account account : bank.getAccount()) {
                        System.out.println(account);
                    }
                } else {
                    System.out.println("No accounts found for this bank.");
                }
            } else {
                System.out.println("Bank does not exist");
            }
        } catch (Exception e) {
            // Rollback the transaction in case of an exception
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            // Clean up resources
            em.close();
            emf.close();
        }
    }
}

package OneToMany_bi_Directional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchByAccount {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bi_directional");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            Account account = em.find(Account.class, 111); // Use correct class name
            et.commit();

            if (account != null) {
                System.out.println("----------------Account-------------------");
                System.out.println(account);

                Bank bank = account.getBank();
                System.out.println("-------------------Bank-------------------");
                System.out.println(bank);

            } else {
                System.out.println("Account does not exist");
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

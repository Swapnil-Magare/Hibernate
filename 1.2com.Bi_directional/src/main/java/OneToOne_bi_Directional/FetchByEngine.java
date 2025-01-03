package OneToOne_bi_Directional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchByEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bi_directional");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Engine engine = em.find(Engine.class, 111);
		et.commit();
		if (engine != null) {
			System.out.println("----------------Engine-------------------");
			System.out.println(engine.getEid());
			System.out.println(engine.getCc());

			Car car = engine.getCar();
			System.out.println("-------------------Car-------------------");
			System.out.println(car.getCid());
			System.out.println(car.getCbrand());

		} else {
			System.out.println("car does not exist");
		}
	}
}

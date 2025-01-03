package OneToOne_bi_Directional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchByCar {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bi_directional");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Car car = em.find(Car.class, 101);
		et.commit();
		if (car != null) {
			System.out.println("-------------------Car-------------------");
			System.out.println(car.getCid());
			System.out.println(car.getCbrand());

			Engine engine = car.getEngine();
			System.out.println("----------------Engine-------------------");
			System.out.println(engine.getEid());
			System.out.println(engine.getCc());

		} else {
			System.out.println("car does not exist");
		}
	}
}

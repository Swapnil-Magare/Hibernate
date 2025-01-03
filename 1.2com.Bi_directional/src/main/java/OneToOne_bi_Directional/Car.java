package OneToOne_bi_Directional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyToOne;

@Entity
public class Car {
	@Id
	private int Cid;
	private String Cbrand;
	@OneToOne
	@JoinColumn(name = "engine_id") // keep Fk columnuse Joincloumn
	private Engine engine;

	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public String getCbrand() {
		return Cbrand;
	}

	public void setCbrand(String cbrand) {
		Cbrand = cbrand;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}

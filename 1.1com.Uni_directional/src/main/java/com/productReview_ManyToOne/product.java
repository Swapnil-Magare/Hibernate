package com.productReview_ManyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class product {
	@Id
	private int pid;
	private String name;
	private double price;

	public product() {

	}

	public product(int pid, String name, double price) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

package com.productReview_ManyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class review {
	@Id
	private int rid;
	private String message;

	public review() {

	}

	@ManyToOne
	private product product;

	public review(int rid, String message, product product) {
		super();
		this.rid = rid;
		this.message = message;
		this.product = product;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Review [rid=" + rid + ", message=" + message + ", product=" + product + "]";
	}
}

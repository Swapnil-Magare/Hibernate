package com.BankAccount_OneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private long accNumber;
	private String name;
	private Long phone;

	public long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Account [accNumber=" + accNumber + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
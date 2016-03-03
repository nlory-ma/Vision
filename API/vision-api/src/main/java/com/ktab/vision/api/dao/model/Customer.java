package com.ktab.vision.api.dao.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerID;
	private String customerName;
	private String phoneNumber;
	private String email;
	@OneToMany
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinTable(name = "CustomerAddress")
	private List<Address> address;
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(mappedBy = "customer")
	private List<Orders> orders;

	public Customer() {
	}

	public Customer(String customerName, String phoneNumber, String email, List<Address> address, List<Orders> orders) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.orders = orders;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

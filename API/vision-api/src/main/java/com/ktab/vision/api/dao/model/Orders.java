package com.ktab.vision.api.dao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Orders")
public abstract class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long orderID;
	@Column(nullable = false)
	String clientOrderID;
	@ManyToOne
	@JoinColumn(name = "customerID")
	Customer customer;
	@OneToOne
	@JoinColumn(name = "pickupAddressId")
	OrderAddress pickupAddress;
	@OneToOne
	@JoinColumn(name = "dropAddressId")
	OrderAddress dropAddress;
	@OneToOne
	@JoinColumn(name = "orderStatusId")
	OrderStatus orderStatus;
	@Temporal(TemporalType.TIMESTAMP)
	Date pickupTime;
	@Temporal(TemporalType.TIMESTAMP)
	Date dropTime;
	@Temporal(TemporalType.TIMESTAMP)
	Date createdOn;
	@ManyToOne
	@JoinColumn(name = "createdBy")
	User createdBy;
	@OneToMany(mappedBy = "order")
	List<OrderAudit> audits;
	@Enumerated(EnumType.STRING)
	PaymentMode paymentMode;
	@OneToOne
	Team team;
	@OneToOne
	Partner partner;

	public Orders() {
		createdOn = new Date();
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public String getClientOrderID() {
		return clientOrderID;
	}

	public void setClientOrderID(String clientOrderID) {
		this.clientOrderID = clientOrderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getPickupAddress() {
		return pickupAddress;
	}

	public OrderAddress getDropAddress() {
		return dropAddress;
	}

	public void setDropAddress(OrderAddress dropAddress) {
		this.dropAddress = dropAddress;
	}

	public void setPickupAddress(OrderAddress pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public Date getDropTime() {
		return dropTime;
	}

	public void setDropTime(Date dropTime) {
		this.dropTime = dropTime;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<OrderAudit> getAudits() {
		return audits;
	}

	public void setAudits(List<OrderAudit> audits) {
		this.audits = audits;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

}

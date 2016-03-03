package com.ktab.vision.api.dao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrderAudit {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(name = "OrderId")
	private Orders order;
	@ManyToOne
	@JoinColumn(name = "orderStatusId")
	private OrderStatus orderStatus;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User auditedBy;
	private String comment;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	public OrderAudit() {
		this.createdOn = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getAuditedBy() {
		return auditedBy;
	}

	public void setAuditedBy(User auditedBy) {
		this.auditedBy = auditedBy;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}

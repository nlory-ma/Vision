package com.ktab.vision.api.dao.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(columnNames = { "Email" }) )
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserId")
	int userId;
	@Column(name = "Email")
	String email;
	@Column(name = "Password")
	String password;
	@Column(name = "FirstName")
	String firstName;
	@Column(name = "LastName")
	String lastName;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedOn")
	Date createdOn;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastLoginDate")
	Date lastLoginDate;
	@OneToMany
	Set<Role> roles;
	boolean isEnabled;

	public User() {
		this.createdOn = new Date();
		this.lastLoginDate = new Date();
	}

	public User(String email, String password, String firstName, String lastName, Date lastLoginDate) {
		this();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastLoginDate = lastLoginDate;
		this.isEnabled = true;
	}

	public User(String email, String password, String firstName, String lastName, boolean isEnabled) {
		this();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isEnabled = isEnabled;
	}

	@PrePersist
	protected void onCreate() {
		createdOn = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		lastLoginDate = new Date();
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

}

package com.ktab.vision.api.dao.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Team {
	@Id
	@GeneratedValue
	private long teamID;
	private String name;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "createdBy")
	private User createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date createdOn;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parentTeamID")
	private Team parent;
	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	private Set<Team> children = new HashSet<Team>();

	public Team() {
		this.createdOn = new Date();
	}

	public Team(String name, User createdBy) {
		this();
		this.name = name;
		this.createdBy = createdBy;
	}

	public Team(String name, Team parent, User createdBy) {
		this(name, createdBy);
		this.parent = parent;
	}

	public long getTeamID() {
		return teamID;
	}

	public void setTeamID(long teamID) {
		this.teamID = teamID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getParent() {
		return parent;
	}

	public void setParent(Team parent) {
		this.parent = parent;
	}

	public Set<Team> getChildren() {
		return children;
	}

	public void setChildren(Set<Team> children) {
		this.children = children;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public boolean addChild(Team team) {
		if (team != null) {
			team.setParent(this);
			return true;
		}
		return false;
	}

}

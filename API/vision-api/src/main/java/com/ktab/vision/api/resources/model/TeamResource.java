package com.ktab.vision.api.resources.model;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

public class TeamResource extends ResourceSupport {

	private long teamId;
	private long parentTeamId;
	private String teamName;
	private long createdBy;
	private Date createdOn;

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public long getParentTeamId() {
		return parentTeamId;
	}

	public void setParentTeamId(long parentTeamId) {
		this.parentTeamId = parentTeamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}

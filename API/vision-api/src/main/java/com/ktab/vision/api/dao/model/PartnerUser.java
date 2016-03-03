package com.ktab.vision.api.dao.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class PartnerUser extends User {
	@OneToOne
	private Partner partner;
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(fetch = FetchType.EAGER)
	Set<Team> team;

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Set<Team> getTeam() {
		return team;
	}

	public void setTeam(Set<Team> team) {
		this.team = team;
	}

}

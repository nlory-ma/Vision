package com.ktab.vision.api.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktab.vision.api.dao.TeamDao;
import com.ktab.vision.api.dao.model.Team;

@Service
public class TeamDaoImpl implements TeamDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public Team getTeam(long teamId) {
		return findByParameter(teamId, "teamID");
	}

	@Override
	@Transactional
	public Set<Team> getSubTeams(long teamId) {
		Team team = findByParameter(teamId, "teamID");
		Set<Team> teams = team.getChildren();
		return teams;
	}

	@SuppressWarnings("unchecked")
	private Team findByParameter(long value, String parameter) {
		List<Team> teams = new ArrayList<Team>();
		teams = sessionFactory.getCurrentSession().createQuery("from Team where " + parameter + "=?").setParameter(0, value).list();
		if (teams.size() > 0) {
			return teams.get(0);
		} else {
			return null;
		}

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

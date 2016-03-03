package com.ktab.vision.api.dao;

import java.util.Set;

import com.ktab.vision.api.dao.model.Team;

public interface TeamDao {

	public Team getTeam(long userId);

	Set<Team> getSubTeams(long teamId);
}

package com.ktab.vision.api.mappers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.HashSet;
import java.util.Set;

import com.ktab.vision.api.controlers.TeamController;
import com.ktab.vision.api.dao.model.Team;
import com.ktab.vision.api.resources.model.TeamResource;

public class TeamResourceMapper {

	public static TeamResource mapTeamResource(Team team) {
		TeamResource teamResource = new TeamResource();
		// Mapping
		teamResource.setCreatedBy(team.getCreatedBy().getUserId());
		teamResource.setCreatedOn(team.getCreatedOn());
		teamResource.setTeamId(team.getTeamID());
		teamResource.setTeamName(team.getName());
		if (team.getParent() != null)
			teamResource.setParentTeamId(team.getParent().getTeamID());

		teamResource.add(linkTo(methodOn(TeamController.class).getTeam(team.getTeamID() + "")).withSelfRel());
		teamResource.add(linkTo(methodOn(TeamController.class).getSubTeams(team.getTeamID() + "")).withRel("children"));
		if (team.getParent() != null)
			teamResource.add(linkTo(methodOn(TeamController.class).getTeam(team.getParent().getTeamID() + "")).withRel("parent"));

		return teamResource;
	}

	public static Set<TeamResource> mapTeamResources(Set<Team> teams) {
		Set<TeamResource> teamResources = new HashSet<TeamResource>();
		for (Team team : teams) {
			teamResources.add(mapTeamResource(team));
		}
		return teamResources;
	}
}

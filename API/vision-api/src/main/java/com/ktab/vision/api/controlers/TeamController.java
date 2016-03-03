package com.ktab.vision.api.controlers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ktab.vision.api.dao.TeamDao;
import com.ktab.vision.api.dao.model.Team;
import com.ktab.vision.api.mappers.TeamResourceMapper;
import com.ktab.vision.api.resources.model.TeamResource;

@Controller
@RequestMapping(value = "/v1/team")
@Secured("ROLE_SUPER_ADMIN")
public class TeamController {

	@Autowired
	TeamDao teamDao;

	@RequestMapping(value = "/{teamId}", method = RequestMethod.GET)
	public HttpEntity<TeamResource> getTeam(@PathVariable("teamId") String teamId) {
		Team team = teamDao.getTeam(Long.parseLong(teamId));
		TeamResource teamResource = TeamResourceMapper.mapTeamResource(team);
		return new ResponseEntity<TeamResource>(teamResource, HttpStatus.OK);
	}

	@RequestMapping(value = "/{teamId}/children", method = RequestMethod.GET)
	public ResponseEntity<Set<TeamResource>> getSubTeams(@PathVariable("teamId") String teamId) {
		Set<Team> team = teamDao.getSubTeams(Long.parseLong(teamId));
		Set<TeamResource> teamResource = TeamResourceMapper.mapTeamResources(team);
		return new ResponseEntity<Set<TeamResource>>(teamResource, HttpStatus.OK);
	}

}

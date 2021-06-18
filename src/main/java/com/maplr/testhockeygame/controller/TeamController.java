package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(path = "/team/{year}", produces = "application/json")
    public Team getTeamByYear(@PathVariable long year) {
        return teamService.getTeamByYear(year);
    }




}

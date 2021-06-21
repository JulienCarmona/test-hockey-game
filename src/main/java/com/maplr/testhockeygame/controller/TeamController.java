package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.service.TeamServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    private final TeamServiceImpl teamService;

    public TeamController(TeamServiceImpl teamService) {
        this.teamService = teamService;
    }

    @GetMapping(path = "/{year}", produces = "application/json")
    public Team getTeamByYear(@PathVariable long year) {
        return Optional.ofNullable(teamService.getTeamByYear(year)).orElseThrow();
    }

    @PostMapping("/{year}")
    public ResponseEntity<Player> addPlayerInTeamByYear(@RequestBody Player player, @PathVariable Long year) {
        return teamService.addPlayerInTeamByYear(year, player)
                ? ResponseEntity.status(HttpStatus.CREATED).body(player)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }



}

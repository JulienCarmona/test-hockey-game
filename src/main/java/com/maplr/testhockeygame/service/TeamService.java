package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.stereotype.Component;

@Component
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository ;
    }

    public Team getTeamByYear(long year) {
        return teamRepository.findByYear(year);
    }

    public void addPlayerInTeamByYear(long year, Player player) {
        Team team = getTeamByYear(year);
        team.getPlayers().add(player);
        teamRepository.save(team);
    }
}

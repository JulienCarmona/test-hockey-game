package com.maplr.testhockeygame.service;

import org.springframework.stereotype.Component;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.repository.TeamRepository;

@Component
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository ;
    }

    public Team getTeamByYear(long year) {
        return teamRepository.findByYear(year);
    }

    public boolean addPlayerInTeamByYear(long year, Player player) {
        Team team = getTeamByYear(year);
        int initSize = team.getPlayers().size();
        team.getPlayers().add(player);
        return initSize+1 == teamRepository.save(team).getPlayers().size();
    }

}

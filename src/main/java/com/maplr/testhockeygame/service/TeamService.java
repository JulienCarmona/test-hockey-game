package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;

public interface TeamService {

    Team getTeamByYear(long year);
    boolean addPlayerInTeamByYear(long year, Player player);

}

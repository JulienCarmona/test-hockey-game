package com.maplr.testhockeygame.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;

@Repository
public interface PlayerRepository extends CrudRepository <Player, Long> {

    Player findByTeamAndIsCaptain(Team team, boolean b);

}

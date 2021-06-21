package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository <Player, Long> {

    Player findByTeamAndIsCaptain(Team team, boolean b);

}

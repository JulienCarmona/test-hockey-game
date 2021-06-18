package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository <Player, Long> {


}

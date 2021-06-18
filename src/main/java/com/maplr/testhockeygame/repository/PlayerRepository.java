package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.service.PlayerService;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepository {

    private PlayerService playerService;

    public PlayerRepository(PlayerService playerService) {
        this.playerService = playerService;
    }


}

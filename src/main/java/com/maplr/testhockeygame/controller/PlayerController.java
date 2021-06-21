package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.service.PlayerServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerServiceImpl playerService;

    public PlayerController(PlayerServiceImpl playerService) {
        this.playerService = playerService;
    }

    @PutMapping("captain/{id}")
    public Player promotePlayerToCaptain(@PathVariable Long id) {
        return playerService.promotePlayerToCaptain(id);
    }

}

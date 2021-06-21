package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player promotePlayerToCaptain(Long id) {
        Player newCaptain = playerRepository.findById(id).orElseThrow();
        Player oldCaptain = playerRepository.findByTeamAndIsCaptain(newCaptain.getTeam(), true);
        oldCaptain.setCaptain(false);
        playerRepository.save(oldCaptain);
        newCaptain.setCaptain(true);
        return playerRepository.save(newCaptain);
    }
}
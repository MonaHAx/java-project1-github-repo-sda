package com.example.SportMS.service.impl;

import com.example.SportMS.model.Player;
import com.example.SportMS.repository.PlayerRepository;
import com.example.SportMS.service.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void updateInformation(Player player, Long id) {
        List<Player> playerList = playerRepository.findAll();
        if(playerList.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player " + id + " not found");
        player.setId(id);
        playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player " + id + " not found");
        playerRepository.deleteById(id);
    }

    @Override
    public Player getPlayerById(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player " + id + " not found");
        return playerOptional.get();
    }
}

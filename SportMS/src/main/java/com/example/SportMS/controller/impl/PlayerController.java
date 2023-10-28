package com.example.SportMS.controller.impl;

import com.example.SportMS.model.Manager;
import com.example.SportMS.model.Player;
import com.example.SportMS.repository.PlayerRepository;
import com.example.SportMS.service.interfaces.IPlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    IPlayerService iPlayerService;

    //--------------------------GET-------------------

    @GetMapping("/player")
    public List<Player> findAll(){
        return playerRepository.findAll();
    }


    @GetMapping("/player/{id}")
    public Player getPlayerById(@PathVariable(name = "id") Long id ) {
        return iPlayerService.getPlayerById(id);
    }


    @GetMapping("/player/sportSpecialization")
    public List<Player> getPlayerBySportSpecialization(@RequestParam(defaultValue = "FIFA") String sportSpecialization) {
        return playerRepository.getBySportSpecialization(sportSpecialization);
    }

    //--------------------------POST-------------------

    @PostMapping("/player")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePlayer(@RequestBody  Player player){
        playerRepository.save(player);
    }


    //--------------------------------PUT-----------------------
    @PutMapping(value = "/player/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlayerInformation(@RequestBody @Valid Player player, @PathVariable Long id){
        iPlayerService.updateInformation(player, id);

    }

    //--------------------------------DELETE-----------------------

    @DeleteMapping("/player/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable Long id) {
        iPlayerService.deletePlayer(id);
    }

}

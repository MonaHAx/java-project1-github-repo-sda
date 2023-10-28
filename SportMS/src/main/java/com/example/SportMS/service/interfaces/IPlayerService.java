package com.example.SportMS.service.interfaces;

import com.example.SportMS.model.Player;

public interface IPlayerService {
    void updateInformation(Player player, Long id);


    void deletePlayer(Long id);

    Player getPlayerById(Long id);

}

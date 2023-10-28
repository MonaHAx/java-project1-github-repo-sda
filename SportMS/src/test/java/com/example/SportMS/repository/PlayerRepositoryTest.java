package com.example.SportMS.repository;

import com.example.SportMS.model.Manager;
import com.example.SportMS.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;


    @Test
    public void testFindAllById() {
        List<Player> players = playerRepository.findAllById(11);
        assertEquals(1, players.size());
        System.out.println(players);

    }

}
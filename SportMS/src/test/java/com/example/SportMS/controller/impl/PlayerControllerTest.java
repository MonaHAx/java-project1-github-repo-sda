package com.example.SportMS.controller.impl;

import com.example.SportMS.model.Player;
import com.example.SportMS.repository.PlayerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PlayerControllerTest {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;
Player player;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }


    @Test
    void getAllPlayers_validRequest_allPlayers() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/player"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ali"));
    }

    @Test
    void getPlayerById_invalidId_notFound() throws Exception {
        mockMvc.perform(get("/player/10").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }


    @Test
    void savePlayer_validBody_playerSaved() throws Exception {
        Player player = new Player();
        player.setId(3L);
        player.setName("Rana");

        String body = objectMapper.writeValueAsString(player);

        mockMvc.perform(post("/player")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();

        Player savedPlayer = playerRepository.findById(3L).orElse(null);
        assertNotNull(savedPlayer);
    }


    @Test
    void updatePlayer_validBody_playerUpdated() throws Exception {
        player.setSportSpecialization("FIFA");

        String body = objectMapper.writeValueAsString(player);

        mockMvc.perform(put("/player/{id}", player.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(playerRepository.findAll().toString().contains("FIFA"));
    }

    @Test
    void deletePlayer_validRequest_playerDeleted() throws Exception {
        Player savedPlayer = playerRepository.save(player);

        mockMvc.perform(delete("/player/{id}", savedPlayer.getId()))
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(playerRepository.existsById(savedPlayer.getId()));
    }
}
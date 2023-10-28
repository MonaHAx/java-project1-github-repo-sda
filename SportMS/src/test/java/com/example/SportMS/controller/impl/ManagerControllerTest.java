package com.example.SportMS.controller.impl;

import com.example.SportMS.controller.dto.ManagerDTO;
import com.example.SportMS.model.Event;
import com.example.SportMS.model.Manager;
import com.example.SportMS.model.Player;
import com.example.SportMS.repository.EventRepository;
import com.example.SportMS.repository.ManagerRepository;
import com.example.SportMS.repository.PlayerRepository;
import com.example.SportMS.service.impl.ManagerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ManagerControllerTest {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    EventRepository eventRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;
    Player player;
    Manager manager;
    ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private ManagerService managerService;



    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllManagers_validRequest_allManager() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/manager"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Mona"));
    }



    @Test
    void savePlayer_validBody_playerSaved() throws Exception {
        Manager manager1 = new Manager();
        manager1.setId(11);
        manager1.setName("Yahya");

        String body = objectMapper.writeValueAsString(manager1);

        mockMvc.perform(post("/manager")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();

        Manager savedManager = managerRepository.findById(11).orElse(null);
        assertNotNull(savedManager);
    }


}

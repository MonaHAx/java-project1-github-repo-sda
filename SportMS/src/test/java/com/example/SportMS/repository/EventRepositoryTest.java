package com.example.SportMS.repository;

import com.example.SportMS.model.Event;
import com.example.SportMS.model.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventRepositoryTest {

    @Autowired
    EventRepository eventRepository;

    @Test
    public void testFindAllById() {
        List<Event> events = eventRepository.findAllById(2);
        assertEquals(1, events.size());
        System.out.println(events);
    }

}
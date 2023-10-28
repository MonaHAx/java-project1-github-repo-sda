package com.example.SportMS.service.impl;

import com.example.SportMS.model.Event;
import com.example.SportMS.model.Player;
import com.example.SportMS.repository.EventRepository;
import com.example.SportMS.service.interfaces.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements IEventService {

    @Autowired
    EventRepository eventRepository;
    @Override
    public void updateInformation(Event event, Long id) {
        List<Event> eventList = eventRepository.findAll();
        if(eventList.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event " + id + " not found");
        event.setId(id);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if (eventOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event " + id + " not found");
        eventRepository.deleteById(id);

    }
}

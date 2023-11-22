package com.example.SportMS.controller.impl;

import com.example.SportMS.model.Event;
import com.example.SportMS.model.Manager;
import com.example.SportMS.model.Player;
import com.example.SportMS.repository.EventRepository;
import com.example.SportMS.service.interfaces.IEventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    IEventService iEventService;

    //--------------------------GET-------------------
    @GetMapping("/event")
    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    @GetMapping("/event/platform")
    public List<Event> getEventByPlatform(@RequestParam(defaultValue = "PS5") String platform) {
        return eventRepository.getByPlatform(platform);
    }

    @GetMapping("/event/{id}")
    public Event getEventById(@PathVariable(name = "id") Long id ) {
        return iEventService.getEventById(id);
    }

//--------------------------POST-------------------

    @PostMapping("/event")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEvent(@RequestBody Event event){
      //  event.setManager(manager);
        eventRepository.save(event);
    }

    //--------------------------------PUT-----------------------
    @PutMapping(value = "/event/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEventInformation(@RequestBody @Valid Event event, @PathVariable Long id){
        iEventService.updateInformation(event, id);

    }

    //--------------------------------DELETE-----------------------

    @DeleteMapping("/event/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable Long id) {
        iEventService.deleteEvent(id);
    }

}
package com.example.SportMS.service.interfaces;

import com.example.SportMS.model.Event;
import com.example.SportMS.model.Player;

public interface IEventService {
    void updateInformation(Event event, Long id);

    void deleteEvent(Long id);


    Event getEventById(Long id);

}

package com.example.SportMS.service.interfaces;

import com.example.SportMS.model.Event;

public interface IEventService {
    void updateInformation(Event event, Long id);

    void deleteEvent(Long id);

}

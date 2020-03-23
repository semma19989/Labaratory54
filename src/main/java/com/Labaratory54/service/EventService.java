package com.Labaratory54.service;

import com.Labaratory54.dto.EventDTO;
import com.Labaratory54.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

@Service
public class EventService {
    @Autowired
    EventRepository er;

    public Iterable<EventDTO> findAllEvent(@ApiIgnore Pageable pageable){
        return er.findAll(pageable).map(EventDTO::from);
    }
}

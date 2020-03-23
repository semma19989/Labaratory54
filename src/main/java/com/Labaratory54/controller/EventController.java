package com.Labaratory54.controller;

import com.Labaratory54.dto.EventDTO;
import com.Labaratory54.service.EventService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/event")
public class EventController {
    EventService es;

    public EventController(EventService es) {
        this.es = es;
    }

    @GetMapping("/all")
    public Iterable<EventDTO> findAll(@ApiIgnore Pageable pageable){
        return es.findAllEvent(pageable);
    }
}

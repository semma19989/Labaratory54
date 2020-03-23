package com.Labaratory54.service;

import com.Labaratory54.model.SubscribeToEvent;
import com.Labaratory54.dto.SubscribeToEventDTO;
import com.Labaratory54.repository.EventRepository;
import com.Labaratory54.repository.SubscribeToEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubscribeToEventService {
    @Autowired
    SubscribeToEventRepository ster;

    @Autowired
    EventRepository er;

    public String createSub(String eventId, String mail){
        if(ster.existsSubscribeToEventByEventIdAndMail(eventId,mail)){
            System.out.println("User already subscribe");
            return null;
        }
        else if(er.findEventById(eventId).getDate().isBefore(LocalDateTime.now())){
            System.out.println("Event has passed. You cannot subscribe");
            return null;
        }
        else{
            System.out.println("User subscribe");
            SubscribeToEvent subscribeToEvent = SubscribeToEvent.builder()
                    .event(er.findEventById(eventId))
                    .mail(mail)
                    .dateRegistration(LocalDateTime.now())
                    .build();
            ster.save(subscribeToEvent);
            return subscribeToEvent.getId();
        }
    }

    public List<SubscribeToEventDTO> findAllSubByMail(String mail){
        Iterable<SubscribeToEvent> subs = ster.findSubscribeToEventsByMail(mail);
        List<SubscribeToEventDTO> subscribeToEventDTOs = new ArrayList<>();
        for (SubscribeToEvent sub:subs) {
            subscribeToEventDTOs.add(SubscribeToEventDTO.from(sub));
        }
        return subscribeToEventDTOs;
    }

    public void cancelSub(String eventId, String mail){
        if(ster.existsSubscribeToEventByEventIdAndMail(eventId,mail)){
            ster.deleteSubscribeToEventByEventIdAndMail(eventId,mail);
            System.out.println("Subscribe cancelled");
        }
        else{
            System.out.println("Subscribe isn't exist");
        }
    }
}

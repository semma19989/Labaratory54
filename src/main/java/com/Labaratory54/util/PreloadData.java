package com.Labaratory54.util;


import com.Labaratory54.model.Event;
import com.Labaratory54.model.SubscribeToEvent;
import com.Labaratory54.repository.EventRepository;
import com.Labaratory54.repository.SubscribeToEventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class PreloadData {

    Random r = new Random();

    private LocalDateTime getDate(){
        return LocalDateTime.of((2015+r.nextInt(10)),
                (1+r.nextInt(12)),(1+r.nextInt(20)),
                (1+r.nextInt(15)),(r.nextInt(50)));
    }

    @Bean
    CommandLineRunner initDatabase(EventRepository er, SubscribeToEventRepository ster) {
        return (args) -> {
            er.deleteAll();
            ster.deleteAll();

            List<Event> events = new ArrayList<>();
            for (int i=0;i<10;i++)
                events.add(Event.addEvent(getDate()));

            er.saveAll(events);

            List<SubscribeToEvent> subscribeToEvents = new ArrayList<>();
            for (int i=0;i<10;i++)
                subscribeToEvents.add(SubscribeToEvent.addSub(events.get(r.nextInt(10))));

            ster.saveAll(subscribeToEvents);

            System.out.println("done");
        };
    }
}

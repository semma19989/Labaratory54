package com.Labaratory54.model;

import com.Labaratory54.util.Generator;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "subscribeToEvents")
@Data
@Builder
public class SubscribeToEvent {
    @Id
    String id;
    @DBRef
    Event event;
    @Indexed
    String mail;
    LocalDateTime dateRegistration;

    public static SubscribeToEvent addSub(Event event){
        return builder()
                .event(event)
                .mail(Generator.makeEmail())
                .dateRegistration(LocalDateTime.now())
                .build();
    }
}

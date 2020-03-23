package com.Labaratory54.dto;

import com.Labaratory54.model.Event;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class EventDTO {
    String id;
    LocalDateTime date;
    String name;
    String description;

    public static EventDTO from(Event event){
        return builder()
                .id(event.getId())
                .date(event.getDate())
                .name(event.getName())
                .description(event.getDescription())
                .build();
    }
}

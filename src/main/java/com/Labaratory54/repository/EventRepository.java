package com.Labaratory54.repository;

import com.Labaratory54.model.Event;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventRepository extends PagingAndSortingRepository<Event,String> {
    Event findEventById(String id);
}

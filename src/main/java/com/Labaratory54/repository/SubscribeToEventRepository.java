package com.Labaratory54.repository;

import com.Labaratory54.model.SubscribeToEvent;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubscribeToEventRepository extends PagingAndSortingRepository<SubscribeToEvent,String> {
    boolean existsSubscribeToEventByEventIdAndMail(String id, String mail);

    void deleteSubscribeToEventByEventIdAndMail(String id, String mail);

    Iterable<SubscribeToEvent> findSubscribeToEventsByMail(String mail);
}

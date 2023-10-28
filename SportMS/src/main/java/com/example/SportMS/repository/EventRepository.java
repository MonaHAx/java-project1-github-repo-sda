package com.example.SportMS.repository;

import com.example.SportMS.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllById(long id);

    Optional<Event> findById(long id);

    List<Event> getByPlatform(String platform);

}

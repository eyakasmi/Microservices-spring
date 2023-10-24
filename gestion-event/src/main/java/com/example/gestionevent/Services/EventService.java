package com.example.gestionevent.Services;

import com.example.gestionevent.Entity.Event;
import com.example.gestionevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public Event getEventById(Long id) {
      //  return eventRepository.findById(id).orElse(null);
        Optional<Event> event = eventRepository.findById(id);
        if (event != null) {
            return event.get();
        } else {
            return null;
        }
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event deleteEvent(Long id) {
      //  eventRepository.deleteById(id);
        Optional<Event> event = eventRepository.findById(id);
        if (event != null) {
            eventRepository.deleteById(id);
            return event.get();
        } else {
            return null;
        }
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = eventRepository.findById(id).orElse(null);
        if (existingEvent != null) {
            existingEvent.setTitle(updatedEvent.getTitle());
            existingEvent.setDescription(updatedEvent.getDescription());
            existingEvent.setStartDate(updatedEvent.getStartDate());
            existingEvent.setEndDate(updatedEvent.getEndDate());
            existingEvent.setCreatedAt(updatedEvent.getCreatedAt());

            return eventRepository.save(existingEvent);
        }
        return null;
    }

    public List<Event> getEventsSortedByEndDate() {
        return eventRepository.findAllByOrderByEndDate();
    }

}
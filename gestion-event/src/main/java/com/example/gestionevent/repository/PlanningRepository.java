package com.example.gestionevent.repository;

import com.example.gestionevent.Entity.Planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanningRepository extends JpaRepository<Planning, Long> {
    @Query("SELECT p FROM Planning p WHERE p.event = :eventId")
    List<Planning> findByEventId(Long eventId);
}

package com.example.gestionevent.Services;

import com.example.gestionevent.Entity.Planning;

import com.example.gestionevent.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanningService {


    private final PlanningRepository planningRepository;

    @Autowired
    public PlanningService(PlanningRepository planningRepository) {
        this.planningRepository = planningRepository;
    }


    public Planning getPlanningById(Long id) {
        Optional<Planning> planning = planningRepository.findById(id);
        if (planning != null) {
            return planning.get();
        } else {
            return null;
        }
    }

    public Planning createPlanning(Planning planning) {
        return planningRepository.save(planning);
    }

    public List<Planning> getAllPlannings() {
        return planningRepository.findAll();
    }

    public Planning deletePlanning(Long id) {
        Optional<Planning> planning = planningRepository.findById(id);
        if (planning != null) {
            planningRepository.deleteById(id);
            return planning.get();
        } else {
            return null;
        }
    }

    public Planning updatePlanning(Long id, Planning updatedPlanning) {
        Planning existingPlanning = planningRepository.findById(id).orElse(null);
        if (existingPlanning != null) {
            existingPlanning.setName(updatedPlanning.getName());
            existingPlanning.setDescription(updatedPlanning.getDescription());
            existingPlanning.setStartDate(updatedPlanning.getStartDate());
            existingPlanning.setEndDate(updatedPlanning.getEndDate());

            return planningRepository.save(existingPlanning);
        }
        return null;
    }

    public List<Planning> getPlanningByEventId(Long eventId) {
        return planningRepository.findByEventId(eventId);
    }
}

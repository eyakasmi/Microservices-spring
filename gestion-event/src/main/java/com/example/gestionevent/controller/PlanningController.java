package com.example.gestionevent.controller;

import com.example.gestionevent.Entity.Event;
import com.example.gestionevent.Entity.Planning;
import com.example.gestionevent.Services.EventService;
import com.example.gestionevent.Services.PlanningService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planning")
public class PlanningController {

    private final PlanningService planningService;

    public PlanningController(PlanningService planningService) {
        this.planningService = planningService;
    }

    @GetMapping("/plannings")
    public List<Planning> getAllPlannings() {
        return planningService.getAllPlannings();
    }

    @GetMapping("/plannings/{id}")
    public Planning getPlanning(@PathVariable Long id) {
        return planningService.getPlanningById(id);
    }

    @PostMapping("/plannings")
    public Planning createPlanning(@RequestBody Planning planning) {
        return planningService.createPlanning(planning);
    }

    @PutMapping("/planning/{id}")
    public Planning updatePlanning(@PathVariable Long id, @RequestBody Planning updatedPlanning) {
        return planningService.updatePlanning(id, updatedPlanning);
    }

    @DeleteMapping("/planning/{id}")
    public Planning deletePlanning(@PathVariable Long id) {
        return planningService.deletePlanning(id);
    }

    @GetMapping("/event/{eventId}")
    public List<Planning> getPlanningByEventId(@PathVariable Long eventId) {
        return planningService.getPlanningByEventId(eventId);
    }

}

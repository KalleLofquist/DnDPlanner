package se.karl.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import se.karl.plan.service.PlanService;
import se.karl.plan.controller.model.PlanDTO;
import se.karl.plan.controller.model.PlanRequest;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanDTO> getPlan(@PathVariable Long id) {
        return ResponseEntity.ok(planService.getPlan(id));
    }

    @PostMapping
    public ResponseEntity<PlanDTO> createPlan(@RequestBody PlanRequest request) {
        PlanDTO created = planService.createPlan(request);
        return ResponseEntity.status(201).body(created);
    }
}
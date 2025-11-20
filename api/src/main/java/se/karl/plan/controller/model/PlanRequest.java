package se.karl.plan.controller.model;

public record PlanRequest(
    String name,
    String description,
    String time,
    String location
) {
    
}

package se.karl.plan.controller.model;

import java.time.LocalDateTime;

import org.jilt.Builder;

@Builder
public record PlanRequest(
    String name,
    String description,
    LocalDateTime time,
    String location
) {
    
}

package se.karl.plan.controller.model;

import java.time.LocalDateTime;

public record PlanDTO(
    Long id,
    String name,
    String description,
    LocalDateTime time,
    String location
) {
    
}

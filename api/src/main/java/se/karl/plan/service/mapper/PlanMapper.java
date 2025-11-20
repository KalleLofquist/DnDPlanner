package se.karl.plan.service.mapper;

import se.karl.plan.controller.model.PlanDTO;
import se.karl.plan.repository.entity.PlanEntity;

public class PlanMapper {
    
    public PlanMapper() {
    }

    public static PlanDTO toDTO(PlanEntity entity) {
        return new PlanDTO(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getTime(),
            entity.getLocation()
        );
    }
}

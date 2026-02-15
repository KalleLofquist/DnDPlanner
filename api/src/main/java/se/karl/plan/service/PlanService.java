package se.karl.plan.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.karl.plan.controller.model.PlanDTO;
import se.karl.plan.controller.model.PlanRequest;
import se.karl.plan.repository.PlanRepository;
import se.karl.plan.repository.entity.PlanEntity;
import se.karl.plan.service.mapper.PlanMapper;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public PlanDTO getPlan(Long id) {
        PlanEntity planEntity = planRepository.findById(id).orElseThrow();
        return PlanMapper.toDTO(planEntity);
    }

    public List<PlanDTO> getAllPlans() {
        return planRepository.findAll().stream()
                .map(PlanMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PlanDTO createPlan(PlanRequest planRequest) {
        PlanEntity planEntity = new PlanEntity();
        planEntity.setName(planRequest.name());
        planEntity.setDescription(planRequest.description());
        planEntity.setTime(planRequest.time());
        planEntity.setLocation(planRequest.location());

        PlanEntity savedPlan = planRepository.save(planEntity);

        return PlanMapper.toDTO(savedPlan);
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
    
}

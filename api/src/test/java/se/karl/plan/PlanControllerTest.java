package se.karl.plan;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import se.karl.BaseTest;
import se.karl.plan.controller.model.PlanDTO;
import se.karl.plan.repository.PlanRepository;
import se.karl.plan.repository.entity.PlanEntity;

public class PlanControllerTest extends BaseTest {

    @Autowired
    private PlanRepository planRepository;

    @Test
    void testGetPlan() {
        // Given
        PlanEntity planEntity = new PlanEntity("Test Plan 1", "Description 1", LocalDateTime.now(), "Location 1");
        PlanEntity saved = planRepository.save(planEntity);

        // When
        PlanDTO plan = this.restTemplate.getForObject(baseUrl() + "/plans/" + saved.getId(), PlanDTO.class);
        
        //Then 
        assertThat(plan).isNotNull();
        assertThat(plan.name()).isEqualTo("Test Plan 1");
    }

    @Test
    void testGetAllPlans() {
        // Given
        planRepository.save(new PlanEntity("Plan A", "Desc A", LocalDateTime.now(), "Loc A"));
        planRepository.save(new PlanEntity("Plan B", "Desc B", LocalDateTime.now(), "Loc B"));

        // When
        PlanDTO[] plans = this.restTemplate.getForObject(baseUrl() + "/plans", PlanDTO[].class);

        // Then
        assertThat(plans).isNotNull();
        assertThat(plans.length).isGreaterThanOrEqualTo(2);
    }

    @Test
    void testCreatePlan() {
        // Given
        PlanDTO newPlan = new PlanDTO(null, "New Plan", "New Desc", LocalDateTime.now(), "New Loc");

        // When
        PlanDTO createdPlan = this.restTemplate.postForObject(baseUrl() + "/plans", newPlan, PlanDTO.class);

        // Then
        assertThat(createdPlan).isNotNull();
        assertThat(createdPlan.id()).isNotNull();
        assertThat(createdPlan.name()).isEqualTo("New Plan");
    }

    @Test
    void testDeletePlan() {
        // Given
        PlanEntity saved = planRepository.save(new PlanEntity("To Delete", "Desc", LocalDateTime.now(), "Loc"));
        Long id = saved.getId();

        // When
        this.restTemplate.delete(baseUrl() + "/plans/" + id);

        // Then
        assertThat(planRepository.findById(id)).isEmpty();
    }

}
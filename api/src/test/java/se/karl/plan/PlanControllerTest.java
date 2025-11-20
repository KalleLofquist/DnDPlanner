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
}
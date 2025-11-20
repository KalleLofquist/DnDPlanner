package se.karl.plan.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import se.karl.plan.repository.entity.PlanEntity;

@Repository
public interface PlanRepository extends ListCrudRepository<PlanEntity, Long> {}

package se.karl.plan.repository.entity;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    private String name;
    
    private String description;
    
    @NonNull
    private LocalDateTime time;
    
    @NonNull
    private String location;

    public PlanEntity() { }

    public PlanEntity(String name, String description, LocalDateTime time, String location) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.location = location;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}

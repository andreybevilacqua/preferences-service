package com.bevilacquas.preferencesservice.domain.entities;

import com.bevilacquas.preferencesservice.application.solution.SolutionRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Solution {
  @Id
  private String name;
  private String type;
  private boolean active;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  public Solution() {}
  public Solution(String name, String type, boolean active, LocalDateTime createdDate, LocalDateTime updatedDate) {
    this.type = type;
    this.name = name;
    this.active = active;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public static Solution newSolutionFrom(SolutionRequest sr, LocalDateTime createdDate, LocalDateTime updatedDate) {
    return new Solution(sr.name(), sr.type(), sr.active(), createdDate, updatedDate);
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public boolean isActive() {
    return active;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public LocalDateTime getUpdatedDate() {
    return updatedDate;
  }
}

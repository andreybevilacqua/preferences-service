package com.bevilacquas.preferencesservice.domain.entities;

import static java.util.UUID.randomUUID;

import com.bevilacquas.preferencesservice.application.solution.SolutionRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class Solution {
  @Id
  private UUID id;
  @Column
  private String name;

  public Solution() {}
  public Solution(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static Solution buildFromSolutionRequest(SolutionRequest sr) {
    return new Solution(randomUUID(), sr.name());
  }

}

package com.bevilacquas.preferencesservice.application.solution;

import com.bevilacquas.preferencesservice.domain.entities.Solution;
import java.time.LocalDateTime;

public record SolutionResponse(String name, String type, boolean active, LocalDateTime createdDate, LocalDateTime updatedDate) {

  public static SolutionResponse newSolutionResponseFrom(Solution solution) {
    return new SolutionResponse(solution.getName(), solution.getType(), solution.isActive(), solution.getCreatedDate(), solution.getUpdatedDate());
  }
}

package com.bevilacquas.preferencesservice.application.solution;

import com.bevilacquas.preferencesservice.domain.entities.Solution;
import java.util.UUID;

public record SolutionResponse(UUID id, String name) {

  public static SolutionResponse buildFromSolution(Solution solution) { return new SolutionResponse(solution.getId(), solution.getName()); }
}

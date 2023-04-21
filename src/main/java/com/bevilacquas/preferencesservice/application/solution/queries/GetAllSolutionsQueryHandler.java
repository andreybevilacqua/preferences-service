package com.bevilacquas.preferencesservice.application.solution.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllSolutionsQueryHandler implements Command.Handler<GetAllSolutionsQuery, List<SolutionResponse>> {

  private final SolutionRepository repo;

  public GetAllSolutionsQueryHandler(SolutionRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<SolutionResponse> handle(GetAllSolutionsQuery command) {
    return repo
        .getAllSolutions()
        .stream()
        .map(SolutionResponse::buildFromSolution)
        .toList();
  }
}

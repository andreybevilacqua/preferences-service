package com.bevilacquas.preferencesservice.application.solution.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GetAllSolutionsQueryHandler implements Command.Handler<GetAllSolutionsQuery, List<SolutionResponse>> {

  private final SolutionRepository repo;

  public GetAllSolutionsQueryHandler(SolutionRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<SolutionResponse> handle(GetAllSolutionsQuery command) {
    return repo
        .findAll()
        .stream()
        .map(SolutionResponse::newSolutionResponseFrom)
        .toList();
  }
}

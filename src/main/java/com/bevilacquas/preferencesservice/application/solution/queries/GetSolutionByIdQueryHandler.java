package com.bevilacquas.preferencesservice.application.solution.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;
import java.util.UUID;

public class GetSolutionByIdQueryHandler implements Command.Handler<GetSolutionByIdQuery, SolutionResponse> {

  private final SolutionRepository repo;

  public GetSolutionByIdQueryHandler(SolutionRepository repo) {
    this.repo = repo;
  }

  @Override
  public SolutionResponse handle(GetSolutionByIdQuery command) {
    return SolutionResponse.buildFromSolution(repo.getReferenceById(command.id()));
  }
}

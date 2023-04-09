package com.bevilacquas.preferencesservice.application.solution.commands;

import static com.bevilacquas.preferencesservice.application.solution.SolutionResponse.buildFromSolution;
import static com.bevilacquas.preferencesservice.domain.entities.Solution.buildFromSolutionRequest;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;

public class CreateSolutionCommandHandler implements Command.Handler<CreateSolutionCommand, SolutionResponse> {

  private final SolutionRepository repo;

  public CreateSolutionCommandHandler(SolutionRepository repo) {
    this.repo = repo;
  }

  @Override
  public SolutionResponse handle(CreateSolutionCommand command) {
    return buildFromSolution(
        repo.save(
            buildFromSolutionRequest(command.sr())
        )
    );
  }
}

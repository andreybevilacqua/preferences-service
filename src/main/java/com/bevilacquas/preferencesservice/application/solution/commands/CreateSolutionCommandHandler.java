package com.bevilacquas.preferencesservice.application.solution.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionRequest;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;
import org.springframework.stereotype.Component;

import static com.bevilacquas.preferencesservice.application.solution.SolutionResponse.buildFromSolution;
import static com.bevilacquas.preferencesservice.domain.entities.Solution.buildFromSolutionRequest;


@Component
public class CreateSolutionCommandHandler implements Command.Handler<CreateSolutionCommand, SolutionResponse> {

  private final SolutionRepository repo;

  public CreateSolutionCommandHandler(SolutionRepository repo) {
    this.repo = repo;
  }

  @Override
  public SolutionResponse handle(CreateSolutionCommand command) {
    if(validateSolutionRequest(command.sr())) return buildFromSolution(repo.save(buildFromSolutionRequest(command.sr())));
    else return null;
  }

  private boolean validateSolutionRequest(SolutionRequest sr) {
    return sr.name() != null && !sr.name().isEmpty();
  }
}

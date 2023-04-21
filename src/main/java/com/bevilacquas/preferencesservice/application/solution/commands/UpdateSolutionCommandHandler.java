package com.bevilacquas.preferencesservice.application.solution.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;
import org.springframework.stereotype.Component;

import static com.bevilacquas.preferencesservice.application.solution.SolutionResponse.buildFromSolution;

@Component
public class UpdateSolutionCommandHandler implements Command.Handler<UpdateSolutionCommand, SolutionResponse> {

  private final SolutionRepository repo;

  public UpdateSolutionCommandHandler(SolutionRepository repo) {
    this.repo = repo;
  }
  @Override
  public SolutionResponse handle(UpdateSolutionCommand command) {
    return
      repo
        .findByName(command.sr().name())
        .map(s -> buildFromSolution(repo.save(s)))
        .orElse(null);
  }
}

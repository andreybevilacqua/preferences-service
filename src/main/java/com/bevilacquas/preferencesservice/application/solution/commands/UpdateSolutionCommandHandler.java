package com.bevilacquas.preferencesservice.application.solution.commands;

import static com.bevilacquas.preferencesservice.application.solution.SolutionResponse.*;
import static com.bevilacquas.preferencesservice.domain.entities.Solution.*;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.domain.entities.Solution;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;

public class UpdateSolutionCommandHandler implements Command.Handler<UpdateSolutionCommand, SolutionResponse> {

  private final SolutionRepository repo;

  public UpdateSolutionCommandHandler(SolutionRepository repo) {
    this.repo = repo;
  }
  @Override
  public SolutionResponse handle(UpdateSolutionCommand command) {
    return buildFromSolution(
        repo.save(
            buildFromSolutionRequest(command.sr()))
    );
  }
}

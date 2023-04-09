package com.bevilacquas.preferencesservice.application.solution.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.domain.entities.Solution;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;

public class DeleteSolutionCommandHandler implements Command.Handler<DeleteSolutionCommand, Boolean> {

  private final SolutionRepository repo;

  public DeleteSolutionCommandHandler(SolutionRepository repo) {
    this.repo = repo;
  }
  @Override
  public Boolean handle(DeleteSolutionCommand command) {
    try{
      repo.delete(Solution.buildFromSolutionRequest(command.sr()));
      return true;
    } catch (Exception e) {
      System.out.println("Error deleting solution: " + e.getMessage());
      return false;
    }
  }
}

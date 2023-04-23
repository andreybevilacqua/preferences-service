package com.bevilacquas.preferencesservice.application.solution.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteSolutionCommandHandler implements Command.Handler<DeleteSolutionCommand, Boolean> {

  private final SolutionRepository repo;

  public DeleteSolutionCommandHandler(SolutionRepository repo) {
    this.repo = repo;
  }

  @Override
  public Boolean handle(DeleteSolutionCommand command) {
    if(command.name().isEmpty()) return false;
    try{
      repo.deleteByName(command.name());
      return true;
    } catch (Exception e) {
      System.out.println("Error deleting solution: " + e.getMessage());
      return false;
    }
  }
}

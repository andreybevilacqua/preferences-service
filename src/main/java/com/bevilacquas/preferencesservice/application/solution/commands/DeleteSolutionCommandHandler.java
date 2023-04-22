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
    try{
      var optSolution = repo.findByName(command.sr().name());
      if(optSolution.isPresent()) {
        repo.delete(optSolution.get());
        return true;
      } else return false;
    } catch (Exception e) {
      System.out.println("Error deleting solution: " + e.getMessage());
      return false;
    }
  }
}

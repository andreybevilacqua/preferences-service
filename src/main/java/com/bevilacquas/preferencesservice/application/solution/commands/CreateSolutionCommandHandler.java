package com.bevilacquas.preferencesservice.application.solution.commands;

import static com.bevilacquas.preferencesservice.application.solution.SolutionResponse.newSolutionResponseFrom;
import static com.bevilacquas.preferencesservice.domain.entities.Solution.newSolutionFrom;
import static java.time.LocalDateTime.now;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionRequest;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;
import org.springframework.stereotype.Component;


@Component
public class CreateSolutionCommandHandler implements Command.Handler<CreateSolutionCommand, SolutionResponse> {

  private final SolutionRepository repo;

  public CreateSolutionCommandHandler(SolutionRepository repo) {
    this.repo = repo;
  }

  @Override
  public SolutionResponse handle(CreateSolutionCommand command) {
    if(validateSolutionRequest(command.sr())) return newSolutionResponseFrom(repo.save(newSolutionFrom(command.sr(), now(), now())));
    else return null;
  }

  private boolean validateSolutionRequest(SolutionRequest sr) {
    return sr.name() != null && !sr.name().isEmpty();
  }
}

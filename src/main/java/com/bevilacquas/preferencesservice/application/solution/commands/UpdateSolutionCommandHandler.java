package com.bevilacquas.preferencesservice.application.solution.commands;

import static com.bevilacquas.preferencesservice.application.solution.SolutionResponse.newSolutionResponseFrom;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.domain.entities.Solution;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

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
        .map(s -> newSolutionResponseFrom(
            repo.save(
                new Solution(s.getName(), command.sr().type(), command.sr().active(), s.getCreatedDate(), LocalDateTime.now())))
        )
        .orElse(null);
  }
}

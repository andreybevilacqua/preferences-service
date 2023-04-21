package com.bevilacquas.preferencesservice.application.universal.commands;

import static com.bevilacquas.preferencesservice.domain.entities.UniversalPreference.buildFromUniversalPreferenceRequest;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UniversalPreferencesRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteUniversalSolutionPreferenceCommandHandler implements Command.Handler<DeleteUniversalSolutionPreferenceCommand, Boolean> {

  private final UniversalPreferencesRepository repo;

  public DeleteUniversalSolutionPreferenceCommandHandler(UniversalPreferencesRepository repo) {
    this.repo = repo;
}
  @Override
  public Boolean handle(DeleteUniversalSolutionPreferenceCommand command) {
    try {
      repo.delete(buildFromUniversalPreferenceRequest(command.upr()));
      return true;
    } catch (Exception e) {
      System.out.println("Error deleting universal preference: " + e.getMessage());
      return false;
    }
  }
}

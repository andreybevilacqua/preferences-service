package com.bevilacquas.preferencesservice.application.preference.commands;

import static com.bevilacquas.preferencesservice.domain.entities.Preference.buildFromPreferenceRequest;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import org.springframework.stereotype.Component;

@Component
public class DeletePreferenceCommandHandler implements Command.Handler<DeletePreferenceCommand, Boolean> {

  private final PreferencesRepository repo;

  public DeletePreferenceCommandHandler(PreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public Boolean handle(DeletePreferenceCommand command) {
    try {
      repo.delete(buildFromPreferenceRequest(command.pr()));
      return true;
    } catch (Exception e) {
      System.out.println("Error deleting preference: " + e.getMessage());
      return false;
    }
  }
}

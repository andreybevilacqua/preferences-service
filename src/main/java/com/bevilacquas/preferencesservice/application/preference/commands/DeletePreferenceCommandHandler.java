package com.bevilacquas.preferencesservice.application.preference.commands;

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
      var optPref = repo.findByName(command.pr().name());
      if(optPref.isPresent()) {
        repo.delete(optPref.get());
        return true;
      } else return false;
    } catch (Exception e) {
      System.out.println("Error deleting preference: " + e.getMessage());
      return false;
    }
  }
}

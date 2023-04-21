package com.bevilacquas.preferencesservice.application.preference.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.PreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import org.springframework.stereotype.Component;

import static com.bevilacquas.preferencesservice.domain.entities.Preference.buildFromPreferenceRequest;

@Component
public class UpdatePreferenceCommandHandler implements Command.Handler<UpdatePreferenceCommand, PreferenceResponse> {

  private final PreferencesRepository repo;

  public UpdatePreferenceCommandHandler(PreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public PreferenceResponse handle(UpdatePreferenceCommand command) {
    return
      repo
        .findByName(command.pr().name())
        .map(p -> new PreferenceResponse(repo.save(buildFromPreferenceRequest(command.pr()))))
        .orElse(null);
  }
}

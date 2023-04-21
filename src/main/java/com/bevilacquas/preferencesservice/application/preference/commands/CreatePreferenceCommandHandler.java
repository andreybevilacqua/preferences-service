package com.bevilacquas.preferencesservice.application.preference.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.PreferenceRequest;
import com.bevilacquas.preferencesservice.application.preference.PreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import org.springframework.stereotype.Component;

import static com.bevilacquas.preferencesservice.application.preference.PreferenceResponse.buildFromPreference;
import static com.bevilacquas.preferencesservice.domain.entities.Preference.buildFromPreferenceRequest;

@Component
public class CreatePreferenceCommandHandler implements Command.Handler<CreatePreferenceCommand, PreferenceResponse> {

  private final PreferencesRepository repo;

  public CreatePreferenceCommandHandler(PreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public PreferenceResponse handle(CreatePreferenceCommand command) {
    if(validatePreferenceRequest(command.pr())) return buildFromPreference(repo.save(buildFromPreferenceRequest(command.pr())));
    else return null;
  }

  private boolean validatePreferenceRequest(PreferenceRequest pr) {
    return pr.name() != null && !pr.name().isEmpty();
  }
}

package com.bevilacquas.preferencesservice.application.preference.commands;

import static com.bevilacquas.preferencesservice.application.preference.PreferenceResponse.buildFromPreference;
import static com.bevilacquas.preferencesservice.domain.entities.Preference.buildFromPreferenceRequest;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.PreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import org.springframework.stereotype.Component;

@Component
public class CreatePreference implements Command.Handler<CreatePreferenceCommand, PreferenceResponse> {

  private final PreferencesRepository repo;

  public CreatePreference(PreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public PreferenceResponse handle(CreatePreferenceCommand command) {
    return buildFromPreference
        (repo.save(
            buildFromPreferenceRequest(command.pr())
            )
        );
  }
}

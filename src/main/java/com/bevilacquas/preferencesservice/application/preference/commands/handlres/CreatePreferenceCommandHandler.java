package com.bevilacquas.preferencesservice.application.preference.commands.handlres;

import static com.bevilacquas.preferencesservice.application.preference.response.PreferenceResponse.buildFromPreference;
import static com.bevilacquas.preferencesservice.domain.entities.Preference.buildFromPreferenceRequest;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.commands.CreatePreferenceCommand;
import com.bevilacquas.preferencesservice.application.preference.response.PreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import org.springframework.stereotype.Component;

@Component
public class CreatePreferenceCommandHandler implements Command.Handler<CreatePreferenceCommand, PreferenceResponse> {

  private final PreferencesRepository repo;

  public CreatePreferenceCommandHandler(PreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public PreferenceResponse handle(CreatePreferenceCommand command) {
    return buildFromPreference
        (repo.save(
            buildFromPreferenceRequest(
                command.pr())
            )
        );
  }
}

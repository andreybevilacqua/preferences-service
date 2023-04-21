package com.bevilacquas.preferencesservice.application.universal.commands;

import static com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse.buildFromUniversalPreference;
import static com.bevilacquas.preferencesservice.domain.entities.UniversalPreference.buildFromUniversalPreferenceRequest;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UniversalPreferencesRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateUniversalSolutionPreferenceCommandHandler implements Command.Handler<CreateUniversalSolutionPreferenceCommand, UniversalPreferenceResponse> {

  private final UniversalPreferencesRepository repo;

  public CreateUniversalSolutionPreferenceCommandHandler(UniversalPreferencesRepository repo) {
    this.repo = repo;
  }
  @Override
  public UniversalPreferenceResponse handle(CreateUniversalSolutionPreferenceCommand command) {
    return buildFromUniversalPreference(
        repo.save(
            buildFromUniversalPreferenceRequest(command.upr()))
    );
  }
}

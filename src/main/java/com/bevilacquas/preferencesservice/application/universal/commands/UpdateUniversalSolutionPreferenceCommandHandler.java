package com.bevilacquas.preferencesservice.application.universal.commands;

import static com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse.buildFromUniversalPreference;
import static com.bevilacquas.preferencesservice.domain.entities.UniversalPreference.buildFromUniversalPreferenceRequest;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UniversalPreferencesRepository;

public class UpdateUniversalSolutionPreferenceCommandHandler implements Command.Handler<UpdateUniversalSolutionPreferenceCommand, UniversalPreferenceResponse> {

  private final UniversalPreferencesRepository repo;

  public UpdateUniversalSolutionPreferenceCommandHandler(UniversalPreferencesRepository repo) {
   this.repo = repo;
  }
  @Override
  public UniversalPreferenceResponse handle(UpdateUniversalSolutionPreferenceCommand command) {
    return buildFromUniversalPreference(repo.save(buildFromUniversalPreferenceRequest(command.upr())));
  }
}

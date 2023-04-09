package com.bevilacquas.preferencesservice.application.universal.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UniversalPreferencesRepository;

public class GetUniversalPreferenceByIdQueryHandler implements Command.Handler<GetUniversalPreferenceByIdQuery, UniversalPreferenceResponse> {

  private final UniversalPreferencesRepository repo;

  public GetUniversalPreferenceByIdQueryHandler(UniversalPreferencesRepository repo) {
    this.repo = repo;
  }
  @Override
  public UniversalPreferenceResponse handle(GetUniversalPreferenceByIdQuery command) {
    return UniversalPreferenceResponse.buildFromUniversalPreference(
        repo.getById(command.id())
    );
  }
}

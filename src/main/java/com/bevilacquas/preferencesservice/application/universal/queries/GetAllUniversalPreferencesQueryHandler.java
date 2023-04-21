package com.bevilacquas.preferencesservice.application.universal.queries;

import static com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse.*;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UniversalPreferencesRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllUniversalPreferencesQueryHandler implements
    Command.Handler<GetAllUniversalPreferencesQuery, List<UniversalPreferenceResponse>> {

  private final UniversalPreferencesRepository repo;

  public GetAllUniversalPreferencesQueryHandler(UniversalPreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<UniversalPreferenceResponse> handle(GetAllUniversalPreferencesQuery command) {
    return repo.getAllUniversalPreferences()
        .stream()
        .map(UniversalPreferenceResponse::buildFromUniversalPreference)
        .toList();
  }
}

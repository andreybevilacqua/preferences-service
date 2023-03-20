package com.bevilacquas.preferencesservice.application.preference.queries.handlres;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.queries.GetAllPreferencesQuery;
import com.bevilacquas.preferencesservice.application.preference.response.PreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GetAllPreferencesQueryHandler implements Command.Handler<GetAllPreferencesQuery, List<PreferenceResponse>> {

  private final PreferencesRepository repo;

  public GetAllPreferencesQueryHandler(PreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<PreferenceResponse> handle(GetAllPreferencesQuery command) {
    return repo
        .getAllPreferences()
        .stream()
        .map(PreferenceResponse::buildFromPreference)
        .toList();
  }
}

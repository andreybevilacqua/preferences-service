package com.bevilacquas.preferencesservice.application.preference.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.PreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllPreferencesQueryHandler implements Command.Handler<GetAllPreferencesQuery, List<PreferenceResponse>> {

  private final PreferencesRepository repo;

  public GetAllPreferencesQueryHandler(PreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<PreferenceResponse> handle(GetAllPreferencesQuery command) {
    return
      repo
        .findAll()
        .stream()
        .map(PreferenceResponse::buildFromPreference)
        .toList();
  }
}

package com.bevilacquas.preferencesservice.application.preference.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.PreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import org.springframework.stereotype.Component;

@Component
public class GetPreferenceByIdQueryHandler implements Command.Handler<GetPreferenceByIdQuery, PreferenceResponse> {

  private final PreferencesRepository repo;

  public GetPreferenceByIdQueryHandler(PreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public PreferenceResponse handle(GetPreferenceByIdQuery command) {
    return repo.findById(command.id())
        .map(PreferenceResponse::buildFromPreference)
        .orElse(null);
  }
}

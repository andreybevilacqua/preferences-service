package com.bevilacquas.preferencesservice.application.universal.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UniversalPreferencesRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GetAllUniversalPreferencesQueryHandler implements
    Command.Handler<GetAllUniversalPreferencesQuery, List<UniversalPreferenceResponse>> {

  private final UniversalPreferencesRepository repo;

  public GetAllUniversalPreferencesQueryHandler(UniversalPreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<UniversalPreferenceResponse> handle(GetAllUniversalPreferencesQuery command) {
    return
        repo
            .findAll()
            .stream()
            .map(UniversalPreferenceResponse::newUniversalPreferenceResponseFrom)
            .toList();
  }
}

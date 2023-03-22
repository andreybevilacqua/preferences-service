package com.bevilacquas.preferencesservice.application.preference.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.PreferenceResponse;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GetPreferenceByIdQueryHandler implements Command.Handler<GetPreferenceByIdQuery, PreferenceResponse> {

  private final PreferencesRepository repo;

  public GetPreferenceByIdQueryHandler(PreferencesRepository repo) {
    this.repo = repo;
  }

  @Override
  public PreferenceResponse handle(GetPreferenceByIdQuery command) {
    return PreferenceResponse.buildFromPreference(repo
                .getReferenceById(command.id()));
  }
}

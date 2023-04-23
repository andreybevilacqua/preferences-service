package com.bevilacquas.preferencesservice.application.universal.commands;

import static com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse.newUniversalPreferenceResponseFrom;
import static com.bevilacquas.preferencesservice.domain.entities.UniversalPreference.newUniversalPreferenceFrom;
import static java.time.LocalDateTime.now;

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
    return newUniversalPreferenceResponseFrom(
        repo.save(
            newUniversalPreferenceFrom(command.upr(), now(), now())
        )
    );
  }
}

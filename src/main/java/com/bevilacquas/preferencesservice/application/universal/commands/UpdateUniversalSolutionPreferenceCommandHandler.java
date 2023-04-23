package com.bevilacquas.preferencesservice.application.universal.commands;

import static com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse.newUniversalPreferenceResponseFrom;
import static java.time.LocalDateTime.now;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse;
import com.bevilacquas.preferencesservice.domain.entities.UniversalPreference;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UniversalPreferencesRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateUniversalSolutionPreferenceCommandHandler
    implements Command.Handler<UpdateUniversalSolutionPreferenceCommand, UniversalPreferenceResponse> {

  private final UniversalPreferencesRepository repo;

  public UpdateUniversalSolutionPreferenceCommandHandler(UniversalPreferencesRepository repo) {
   this.repo = repo;
  }

  @Override
  public UniversalPreferenceResponse handle(UpdateUniversalSolutionPreferenceCommand command) {
    return
        repo
            .findById(command.upr().name())
            .map(up -> newUniversalPreferenceResponseFrom(
                repo.save(
                    new UniversalPreference(up.getName(), command.upr().value(), command.upr().active(), up.getCreatedDate(), now())
                ))
            )
            .orElse(null);
  }
}

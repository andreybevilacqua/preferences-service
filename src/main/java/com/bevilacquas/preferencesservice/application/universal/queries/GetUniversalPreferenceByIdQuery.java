package com.bevilacquas.preferencesservice.application.universal.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse;
import java.util.UUID;

public record GetUniversalPreferenceByIdQuery (UUID id) implements Command<UniversalPreferenceResponse> {

}

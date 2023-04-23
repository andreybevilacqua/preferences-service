package com.bevilacquas.preferencesservice.application.universal.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse;

public record GetUniversalPreferenceByIdQuery (String name) implements Command<UniversalPreferenceResponse> {

}

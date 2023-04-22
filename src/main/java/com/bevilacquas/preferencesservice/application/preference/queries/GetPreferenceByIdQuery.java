package com.bevilacquas.preferencesservice.application.preference.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.PreferenceResponse;
import java.util.UUID;

public record GetPreferenceByIdQuery(UUID id) implements Command<PreferenceResponse> { }
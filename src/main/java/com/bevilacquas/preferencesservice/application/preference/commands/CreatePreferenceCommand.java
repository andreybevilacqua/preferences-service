package com.bevilacquas.preferencesservice.application.preference.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.request.PreferenceRequest;
import com.bevilacquas.preferencesservice.application.preference.response.PreferenceResponse;

public record CreatePreferenceCommand(PreferenceRequest pr) implements Command<PreferenceResponse> {}
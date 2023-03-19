package com.bevilacquas.preferencesservice.application.preference.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.PreferenceRequest;
import com.bevilacquas.preferencesservice.application.preference.PreferenceResponse;

public record CreatePreferenceCommand(PreferenceRequest pr) implements Command<PreferenceResponse> {}
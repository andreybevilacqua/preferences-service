package com.bevilacquas.preferencesservice.application.preference.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.PreferenceRequest;

public record DeletePreferenceCommand (PreferenceRequest pr) implements Command<Boolean> {}
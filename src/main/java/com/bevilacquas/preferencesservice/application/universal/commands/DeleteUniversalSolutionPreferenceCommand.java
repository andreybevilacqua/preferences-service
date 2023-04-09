package com.bevilacquas.preferencesservice.application.universal.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceRequest;

public record DeleteUniversalSolutionPreferenceCommand (UniversalPreferenceRequest upr) implements Command<Boolean> {

}

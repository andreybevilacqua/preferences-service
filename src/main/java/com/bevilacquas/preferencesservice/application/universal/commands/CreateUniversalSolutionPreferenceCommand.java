package com.bevilacquas.preferencesservice.application.universal.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceRequest;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse;

public record CreateUniversalSolutionPreferenceCommand (UniversalPreferenceRequest upr) implements Command<UniversalPreferenceResponse> {

}

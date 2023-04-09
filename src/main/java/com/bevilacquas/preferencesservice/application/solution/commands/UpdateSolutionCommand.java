package com.bevilacquas.preferencesservice.application.solution.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionRequest;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;

public record UpdateSolutionCommand (SolutionRequest sr) implements Command<SolutionResponse> {

}

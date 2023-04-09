package com.bevilacquas.preferencesservice.application.solution.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionRequest;

public record DeleteSolutionCommand(SolutionRequest sr) implements Command<Boolean> {

}

package com.bevilacquas.preferencesservice.application.solution.commands;

import an.awesome.pipelinr.Command;

public record DeleteSolutionCommand(String name) implements Command<Boolean> {

}

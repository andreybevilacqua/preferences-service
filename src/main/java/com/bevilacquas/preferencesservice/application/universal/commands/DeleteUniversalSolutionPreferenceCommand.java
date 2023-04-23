package com.bevilacquas.preferencesservice.application.universal.commands;

import an.awesome.pipelinr.Command;

public record DeleteUniversalSolutionPreferenceCommand (String name) implements Command<Boolean> {

}

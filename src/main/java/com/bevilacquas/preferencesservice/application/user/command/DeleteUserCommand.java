package com.bevilacquas.preferencesservice.application.user.command;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.user.UserRequest;
import java.util.UUID;

public record DeleteUserCommand(UserRequest userRequest) implements Command<Boolean> {

}

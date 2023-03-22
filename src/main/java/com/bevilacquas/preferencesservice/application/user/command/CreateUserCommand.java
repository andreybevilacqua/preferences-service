package com.bevilacquas.preferencesservice.application.user.command;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.user.UserRequest;
import com.bevilacquas.preferencesservice.application.user.UserResponse;

public record CreateUserCommand(UserRequest ur) implements Command<UserResponse> {}

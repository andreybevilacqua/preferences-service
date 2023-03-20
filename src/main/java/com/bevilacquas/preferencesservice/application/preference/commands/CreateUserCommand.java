package com.bevilacquas.preferencesservice.application.preference.commands;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.request.UserRequest;
import com.bevilacquas.preferencesservice.application.preference.response.UserResponse;

public record CreateUserCommand(UserRequest ur) implements Command<UserResponse> {}

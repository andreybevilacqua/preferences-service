package com.bevilacquas.preferencesservice.application.user.command;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.user.UserRequest;
import com.bevilacquas.preferencesservice.application.user.UserResponse;

public record UpdateUserCommand(UserRequest userRequest) implements Command<UserResponse> {

}

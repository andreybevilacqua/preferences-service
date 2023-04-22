package com.bevilacquas.preferencesservice.application.user.query;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.user.UserResponse;
import java.util.UUID;

public record GetUserByIdQuery(UUID id) implements Command<UserResponse> {

}

package com.bevilacquas.preferencesservice.application.user.query;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.user.UserResponse;
import java.util.List;

public record GetAllUsersQuery() implements Command<List<UserResponse>> {}

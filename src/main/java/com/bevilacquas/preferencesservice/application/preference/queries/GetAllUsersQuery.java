package com.bevilacquas.preferencesservice.application.preference.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.response.UserResponse;

import java.util.List;

public record GetAllUsersQuery() implements Command<List<UserResponse>> {}

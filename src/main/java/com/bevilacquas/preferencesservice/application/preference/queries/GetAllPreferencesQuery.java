package com.bevilacquas.preferencesservice.application.preference.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.preference.response.PreferenceResponse;
import java.util.List;

public record GetAllPreferencesQuery() implements Command<List<PreferenceResponse>> { }
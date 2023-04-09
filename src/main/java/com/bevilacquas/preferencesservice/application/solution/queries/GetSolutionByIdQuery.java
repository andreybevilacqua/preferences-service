package com.bevilacquas.preferencesservice.application.solution.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import java.util.UUID;

public record GetSolutionByIdQuery(UUID id) implements Command<SolutionResponse> {

}

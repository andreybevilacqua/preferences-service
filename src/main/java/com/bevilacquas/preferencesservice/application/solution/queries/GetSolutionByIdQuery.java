package com.bevilacquas.preferencesservice.application.solution.queries;

import an.awesome.pipelinr.Command;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;

public record GetSolutionByIdQuery(String name) implements Command<SolutionResponse> {

}

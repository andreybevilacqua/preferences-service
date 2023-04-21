package com.bevilacquas.preferencesservice.api;

import an.awesome.pipelinr.Pipeline;
import com.bevilacquas.preferencesservice.application.solution.SolutionRequest;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.application.solution.commands.CreateSolutionCommand;
import com.bevilacquas.preferencesservice.application.solution.commands.DeleteSolutionCommand;
import com.bevilacquas.preferencesservice.application.solution.commands.UpdateSolutionCommand;
import com.bevilacquas.preferencesservice.application.solution.queries.GetAllSolutionsQuery;
import com.bevilacquas.preferencesservice.application.solution.queries.GetSolutionByIdQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.UUID.fromString;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/solutions")
public class SolutionsController {

  private final Pipeline pipeline;

  public SolutionsController(Pipeline pipeline) { this.pipeline = pipeline; }

  @GetMapping
  public ResponseEntity<List<SolutionResponse>> getAllSolutions() {
    return new ResponseEntity<>(new GetAllSolutionsQuery().execute(pipeline), OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SolutionResponse> getSolutionsById(@PathVariable String id) {
    var result = new GetSolutionByIdQuery(fromString(id)).execute(pipeline);
    if(result != null) return new ResponseEntity<>(result, OK);
    else return new ResponseEntity<>(NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<SolutionResponse> createSolution(@RequestBody SolutionRequest sr) {
    var result = new CreateSolutionCommand(sr).execute(pipeline);
    if(result != null) return new ResponseEntity<>(result, CREATED);
    else return new ResponseEntity<>(BAD_REQUEST);
  }

  @PutMapping
  public ResponseEntity<SolutionResponse> updateSolution(@RequestBody SolutionRequest sr) {
    return new ResponseEntity<>(new UpdateSolutionCommand(sr).execute(pipeline), OK);
  }

  @DeleteMapping
  public ResponseEntity<Boolean> deleteSolution(@RequestBody SolutionRequest sr) {
    return new ResponseEntity<>(new DeleteSolutionCommand(sr).execute(pipeline), OK);
  }
}

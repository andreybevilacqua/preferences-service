package com.bevilacquas.preferencesservice.api;

import static java.util.UUID.fromString;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import an.awesome.pipelinr.Pipeline;
import com.bevilacquas.preferencesservice.application.solution.SolutionRequest;
import com.bevilacquas.preferencesservice.application.solution.SolutionResponse;
import com.bevilacquas.preferencesservice.application.solution.commands.CreateSolutionCommand;
import com.bevilacquas.preferencesservice.application.solution.commands.DeleteSolutionCommand;
import com.bevilacquas.preferencesservice.application.solution.commands.UpdateSolutionCommand;
import com.bevilacquas.preferencesservice.application.solution.queries.GetAllSolutionsQuery;
import com.bevilacquas.preferencesservice.application.solution.queries.GetSolutionByIdQuery;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<Boolean> deleteSolution(@RequestBody String name) {
    return new ResponseEntity<>(new DeleteSolutionCommand(name).execute(pipeline), OK);
  }
}

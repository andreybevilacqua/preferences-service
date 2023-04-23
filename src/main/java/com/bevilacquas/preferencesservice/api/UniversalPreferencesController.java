package com.bevilacquas.preferencesservice.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import an.awesome.pipelinr.Pipeline;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceRequest;
import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceResponse;
import com.bevilacquas.preferencesservice.application.universal.commands.CreateUniversalSolutionPreferenceCommand;
import com.bevilacquas.preferencesservice.application.universal.commands.DeleteUniversalSolutionPreferenceCommand;
import com.bevilacquas.preferencesservice.application.universal.commands.UpdateUniversalSolutionPreferenceCommand;
import com.bevilacquas.preferencesservice.application.universal.queries.GetAllUniversalPreferencesQuery;
import com.bevilacquas.preferencesservice.application.universal.queries.GetUniversalPreferenceByIdQuery;
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
@RequestMapping("/api/v1/universal-preferences")
public class UniversalPreferencesController {
  private final Pipeline pipeline;

  public UniversalPreferencesController(Pipeline pipeline) { this.pipeline = pipeline; }

  @GetMapping
  public ResponseEntity<List<UniversalPreferenceResponse>> getAllUniversalPreferences() {
    return new ResponseEntity<>(new GetAllUniversalPreferencesQuery().execute(pipeline), OK);
  }

  @GetMapping("/{name}")
  public ResponseEntity<UniversalPreferenceResponse> getUniversalPreferencesById(@PathVariable String name) {
    return new ResponseEntity<>(new GetUniversalPreferenceByIdQuery(name).execute(pipeline), OK);
  }

  @PostMapping
  public ResponseEntity<UniversalPreferenceResponse> createUniversalPreference(@RequestBody UniversalPreferenceRequest upr) {
    return new ResponseEntity<>(new CreateUniversalSolutionPreferenceCommand(upr).execute(pipeline), CREATED);
  }

  @PutMapping
  public ResponseEntity<UniversalPreferenceResponse> updateUniversalPreference(@RequestBody UniversalPreferenceRequest upr) {
    return new ResponseEntity<>(new UpdateUniversalSolutionPreferenceCommand(upr).execute(pipeline), OK);
  }

  @DeleteMapping
  public ResponseEntity<Boolean> deleteUniversalPreference(@RequestBody String name) {
    return new ResponseEntity<>(new DeleteUniversalSolutionPreferenceCommand(name).execute(pipeline), OK);
  }
}

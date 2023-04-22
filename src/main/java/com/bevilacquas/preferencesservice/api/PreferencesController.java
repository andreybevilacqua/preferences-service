package com.bevilacquas.preferencesservice.api;

import static java.util.UUID.fromString;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.bevilacquas.preferencesservice.application.preference.PreferenceRequest;
import com.bevilacquas.preferencesservice.application.preference.PreferenceResponse;
import com.bevilacquas.preferencesservice.application.preference.commands.CreatePreferenceCommand;
import com.bevilacquas.preferencesservice.application.preference.commands.DeletePreferenceCommand;
import com.bevilacquas.preferencesservice.application.preference.commands.UpdatePreferenceCommand;
import com.bevilacquas.preferencesservice.application.preference.queries.GetAllPreferencesQuery;
import com.bevilacquas.preferencesservice.application.preference.queries.GetPreferenceByIdQuery;
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
@RequestMapping("/api/v1/preferences")
public class PreferencesController implements Command<PreferenceResponse> {

  private final Pipeline pipeline;

  public PreferencesController(Pipeline pipeline) {
    this.pipeline = pipeline;
  }

  @GetMapping
  public ResponseEntity<List<PreferenceResponse>> getAllPreferences() {
    return new ResponseEntity<>(new GetAllPreferencesQuery().execute(pipeline), OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PreferenceResponse> getPreferenceById(@PathVariable String id) {
    var result = new GetPreferenceByIdQuery(fromString(id)).execute(pipeline);
    if(result != null) return new ResponseEntity<>(result, OK);
    else return new ResponseEntity<>(NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<PreferenceResponse> createPreference(@RequestBody PreferenceRequest pr) {
    var result = new CreatePreferenceCommand(pr).execute(pipeline);
    if(result != null) return new ResponseEntity<>(result, CREATED);
    else return new ResponseEntity<>(BAD_REQUEST);
  }

  @PutMapping
  public ResponseEntity<PreferenceResponse> updatePreference(@RequestBody PreferenceRequest pr) {
    return new ResponseEntity<>(new UpdatePreferenceCommand(pr).execute(pipeline), OK);
  }

  @DeleteMapping
  public ResponseEntity<Boolean> deletePreference(@RequestBody PreferenceRequest pr) {
    return new ResponseEntity<>(new DeletePreferenceCommand(pr).execute(pipeline), OK);
  }
}

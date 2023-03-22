package com.bevilacquas.preferencesservice.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.bevilacquas.preferencesservice.application.preference.PreferenceRequest;
import com.bevilacquas.preferencesservice.application.preference.PreferenceResponse;
import com.bevilacquas.preferencesservice.application.preference.commands.CreatePreferenceCommand;
import com.bevilacquas.preferencesservice.application.preference.queries.GetAllPreferencesQuery;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
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
  public ResponseEntity<List<PreferenceResponse>> getPreferenceById(@RequestAttribute UUID id) {
    return new ResponseEntity<>(new GetAllPreferencesQuery().execute(pipeline), OK);
  }

  @PostMapping
  public ResponseEntity<PreferenceResponse> createPreference(@RequestBody PreferenceRequest pr) {
    return new ResponseEntity<>(new CreatePreferenceCommand(pr).execute(pipeline), CREATED);
  }
}

package com.bevilacquas.preferencesservice.application.preference;

import com.bevilacquas.preferencesservice.domain.entities.Preference;

import java.util.Optional;

import static java.util.Optional.of;

public record PreferenceResponse(Optional<Preference> preference){
  public static PreferenceResponse buildFromPreference(Preference p) {
    return new PreferenceResponse(of(p));
  }
}

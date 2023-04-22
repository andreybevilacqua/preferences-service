package com.bevilacquas.preferencesservice.application.preference;

import com.bevilacquas.preferencesservice.domain.entities.Preference;
import java.util.UUID;

public record PreferenceResponse(UUID id, String name){
  public static PreferenceResponse buildFromPreference(Preference p) { return new PreferenceResponse(p.getId(), p.getName()); }
}
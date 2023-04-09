package com.bevilacquas.preferencesservice.application.universal;

import com.bevilacquas.preferencesservice.domain.entities.UniversalPreference;
import java.util.UUID;

public record UniversalPreferenceResponse(UUID id, String name) {

  public static UniversalPreferenceResponse buildFromUniversalPreference(UniversalPreference usr) {
    return new UniversalPreferenceResponse(usr.getId(), usr.getName());
  }

}

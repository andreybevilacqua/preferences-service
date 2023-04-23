package com.bevilacquas.preferencesservice.application.universal;

import com.bevilacquas.preferencesservice.domain.entities.UniversalPreference;
import java.time.LocalDateTime;

public record UniversalPreferenceResponse(String name, String value, boolean active, LocalDateTime createdDate, LocalDateTime updateDate) {

  public static UniversalPreferenceResponse newUniversalPreferenceResponseFrom(UniversalPreference usr) {
    return new UniversalPreferenceResponse(usr.getName(), usr.getValue(), usr.isActive(), usr.getCreatedDate(), usr.getUpdatedDate());
  }
}

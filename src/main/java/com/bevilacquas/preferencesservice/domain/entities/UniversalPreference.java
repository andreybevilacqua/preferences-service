package com.bevilacquas.preferencesservice.domain.entities;

import static java.util.UUID.randomUUID;

import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity(name = "Universal_Preference")
public class UniversalPreference {
  @Id
  private UUID id;
  private String name;

  public UniversalPreference() {}

  public UniversalPreference(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static UniversalPreference buildFromUniversalPreferenceRequest(UniversalPreferenceRequest usr) {
    return new UniversalPreference(randomUUID(), usr.name());
  }
}

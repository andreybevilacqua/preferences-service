package com.bevilacquas.preferencesservice.domain.entities;

import static java.util.UUID.randomUUID;

import com.bevilacquas.preferencesservice.application.preference.PreferenceRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class Preference {

  @Id
  private UUID id;
  @Column
  private String name;

  @SuppressWarnings("unused")
  public Preference() {}
  public Preference(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static Preference buildFromPreferenceRequest(PreferenceRequest pr) {
    return new Preference(randomUUID(), pr.name());
  }
}

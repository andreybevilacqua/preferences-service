package com.bevilacquas.preferencesservice.domain.entities;

import com.bevilacquas.preferencesservice.application.universal.UniversalPreferenceRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "Universal_Preference")
public class UniversalPreference {

  @Id
  private String name;

  @Column
  private String value;

  @Column
  private boolean active;

  @Column(name = "created_date")
  private LocalDateTime createdDate;

  @Column(name = "updated_date")
  private LocalDateTime updatedDate;

  public UniversalPreference() {}

  public UniversalPreference(String name, String value, boolean active, LocalDateTime createdDate, LocalDateTime updatedDate) {
    this.name = name;
    this.value = value;
    this.active = active;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public static UniversalPreference newUniversalPreferenceFrom(UniversalPreferenceRequest usr, LocalDateTime createdDate, LocalDateTime updatedDate) {
    return new UniversalPreference(usr.name(), usr.value(), usr.active(), createdDate, updatedDate);
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }

  public boolean isActive() {
    return active;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public LocalDateTime getUpdatedDate() {
    return updatedDate;
  }
}

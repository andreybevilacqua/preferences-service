package com.bevilacquas.preferencesservice.infrastructure.persistence;

import com.bevilacquas.preferencesservice.domain.entities.Preference;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends JpaRepository<Preference, UUID> {

  @Query("SELECT p FROM Preference p")
  List<Preference> getAllPreferences();

  @Query(
    "SELECT p FROM Preference p " +
    "WHERE p.name = :name "
  )
  Optional<Preference> findByName(String name);
}

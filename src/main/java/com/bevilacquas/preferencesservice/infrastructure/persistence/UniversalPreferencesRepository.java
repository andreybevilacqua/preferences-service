package com.bevilacquas.preferencesservice.infrastructure.persistence;

import com.bevilacquas.preferencesservice.domain.entities.UniversalPreference;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UniversalPreferencesRepository extends JpaRepository<UniversalPreference, String> {

  @Query(value =
      "DELETE FROM Universal_Preference up " +
      "WHERE up.name = :name ")
  void deleteByName(String name);
}

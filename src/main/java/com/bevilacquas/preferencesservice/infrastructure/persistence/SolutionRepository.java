package com.bevilacquas.preferencesservice.infrastructure.persistence;

import com.bevilacquas.preferencesservice.domain.entities.Solution;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolutionRepository extends JpaRepository<Solution, String> {

  @Query(value =
      "DELETE FROM Solution s " +
      "WHERE s.name = :name ")
  void deleteByName(String name);

}

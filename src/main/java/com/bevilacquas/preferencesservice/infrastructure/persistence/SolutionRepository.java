package com.bevilacquas.preferencesservice.infrastructure.persistence;

import com.bevilacquas.preferencesservice.domain.entities.Solution;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolutionRepository extends JpaRepository<Solution, UUID> {

  @Query("SELECT s FROM Solution s")
  List<Solution> getAllSolutions();
}

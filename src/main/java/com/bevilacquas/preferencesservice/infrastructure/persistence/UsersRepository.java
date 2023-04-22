package com.bevilacquas.preferencesservice.infrastructure.persistence;

import com.bevilacquas.preferencesservice.domain.entities.User;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, UUID> {

  @Query("SELECT u FROM UserApp u")
  List<User> getAllUsers();
}

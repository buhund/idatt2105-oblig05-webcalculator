package edu.backend.repository;

import edu.backend.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
  AppUser findByUsername(String username);

  boolean existsByUsername(String username); // Add this line
}

package edu.backend.repository;

import edu.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);

  boolean existsByUsername(String username); // Add this line
}

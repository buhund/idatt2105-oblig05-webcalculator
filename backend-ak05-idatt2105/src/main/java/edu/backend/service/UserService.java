package edu.backend.service;

import edu.backend.model.User;
import edu.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User registerNewUser(String username, String rawPassword) {
    if (userRepository.findByUsername(username).isPresent()) {
      throw new IllegalArgumentException("Username already taken.");
    }
    User newUser = new User();
    newUser.setUsername(username);
    // Encode the password before saving
    newUser.setPassword(passwordEncoder.encode(rawPassword));
    return userRepository.save(newUser);
  }

  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  // Additional user-related methods here
}

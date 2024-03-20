package edu.backend.service;

import edu.backend.model.User;
import edu.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public void authenticate(String username, String password) throws Exception {
    User user = userRepository.findByUsername(username);
    if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
      throw new Exception("Invalid username/password");
    }
  }

  public User registerUser(User newUser) throws Exception {
    if(userRepository.existsByUsername(newUser.getUsername())) {
      throw new Exception("Username already taken");
    }
    newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
    return userRepository.save(newUser);
  }
}

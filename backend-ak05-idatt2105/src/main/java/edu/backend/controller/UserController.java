package edu.backend.controller;

import edu.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import edu.backend.model.User;
import edu.backend.model.Calculation;
import edu.backend.repository.CalculationRepository;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
  private final UserRepository userRepository;
  private final CalculationRepository calculationRepository;

  public UserController(UserRepository userRepository, CalculationRepository calculationRepository) {
    this.userRepository = userRepository;
    this.calculationRepository = calculationRepository;
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  @PostMapping("/{id}/calculations")
  public Calculation createCalculation(@PathVariable Long id, @RequestBody Calculation calculation) {
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    calculation.setUser(user);
    return calculationRepository.save(calculation);
  }

  @GetMapping("/{id}/calculations")
  public List<Calculation> getCalculations(@PathVariable Long id) {
    return calculationRepository.findByUserId(id);
  }
}

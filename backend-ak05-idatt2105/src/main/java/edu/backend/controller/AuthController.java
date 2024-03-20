package edu.backend.controller;

// AuthController.java
import edu.backend.service.AuthService;
import edu.backend.utility.JWTUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  private JWTUtil jwtUtil;
  private AuthService authService;

  public AuthController(JWTUtil jwtUtil, AuthService authService) {
    this.jwtUtil = jwtUtil;
    this.authService = authService;
  }

  @PostMapping("/authenticate")
  public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
    try {
      authService.authenticate(authRequest.getUsername(), authRequest.getPassword());
    } catch (Exception e) {
      throw new Exception("Invalid username/password");
    }
    return jwtUtil.generateToken(authRequest.getUsername());
  }
}
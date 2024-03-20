package edu.backend.controller;

import edu.backend.model.User;
import edu.backend.service.AuthService;
import edu.backend.utility.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<?> generateToken(@RequestBody User authRequest) {
    try {
      authService.authenticate(authRequest.getUsername(), authRequest.getPassword());
      String token = jwtUtil.generateToken(authRequest.getUsername());
      return ResponseEntity.ok(new AuthResponse(token));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid username/password", false));
    }
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody User newUser) {
    try {
      User user = authService.registerUser(newUser);
      return ResponseEntity.ok(new ApiResponse("User registered successfully", true));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), false));
    }
  }
}

class AuthResponse {
  private String token;

  public AuthResponse(String token) {
    this.token = token;
  }

  // Getters and setters
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}

class ApiResponse {
  private String message;
  private boolean success;

  public ApiResponse(String message, boolean success) {
    this.message = message;
    this.success = success;
  }

  // Getters and setters
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }
}

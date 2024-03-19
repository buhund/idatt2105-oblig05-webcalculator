package edu.backend.dto;

public class RegistrationRequest {

  private String username;
  private String password;

  // Default constructor
  public RegistrationRequest() {
  }

  // Constructor with parameters
  public RegistrationRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // Getters and Setters
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // toString method for debugging
  @Override
  public String toString() {
    return "RegistrationRequest{" +
        "username='" + username + '\'' +
        ", password='[PROTECTED]'" + // Never log passwords
        '}';
  }
}

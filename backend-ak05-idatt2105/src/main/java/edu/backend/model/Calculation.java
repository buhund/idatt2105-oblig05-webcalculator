package edu.backend.model;

import jakarta.persistence.*;

@Entity
public class Calculation {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String expression;
  private String result;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private AppUser appUser;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public AppUser getUser() {
    return appUser;
  }

  public void setUser(AppUser appUser) {
    this.appUser = appUser;
  }
}
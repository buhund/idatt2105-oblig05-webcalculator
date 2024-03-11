package edu.backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

  private final String secret = "yourSecretKey"; // Use a strong secret key

  public String generateToken(String username) {
    long nowMillis = System.currentTimeMillis();
    long expMillis = nowMillis + 300000; // Token validity 5 minutes
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date(nowMillis))
        .setExpiration(new Date(expMillis))
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }

  public String extractUsername(String token) {
    return getClaims(token).getSubject();
  }

  public boolean validateToken(String token) {
    return !getClaims(token).getExpiration().before(new Date());
  }

  private Claims getClaims(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
  }
}

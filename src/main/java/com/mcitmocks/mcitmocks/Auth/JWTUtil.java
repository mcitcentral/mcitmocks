package com.mcitmocks.mcitmocks.Auth;

import com.mcitmocks.mcitmocks.User.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil {
  private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
  private static final String secret = "fake-secret";

  public static String getEmailFromToken(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
  }

  public static Date getExpirationFromToken(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration();
  }

  private static boolean isTokenExpired(String token) {
    Date tokenExpiration = getExpirationFromToken((token));
    return tokenExpiration.after(new Date());
  }

  public static String generateToken(User user) {
    return Jwts.builder()
        .setSubject(user.getEmail())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }

  public static boolean verifyToken(String token) {
    return isTokenExpired(token);
  }

  public static boolean verifyToken(String token, String email) {
    String tokenEmail = getEmailFromToken(token);
    return (email.equals(tokenEmail) && isTokenExpired(token));
  }
}

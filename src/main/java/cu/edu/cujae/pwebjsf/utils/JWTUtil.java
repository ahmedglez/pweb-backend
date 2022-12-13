package cu.edu.cujae.pwebjsf.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pwebjsf.config.GlobalConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

  @Autowired
  private GlobalConfig globalConfig;

  public String generateToken(UserDetails userDetails) {
    return Jwts
      .builder()
      .setSubject(userDetails.getUsername())
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
      .signWith(SignatureAlgorithm.HS256, globalConfig.getJwt_secret())
      .compact();
  }

  public boolean validateToken(String token, UserDetails userDetails) {
    return (
      userDetails.getUsername().equals(extractUsername(token)) &&
      !isTokenExpired(token)
    );
  }

  public String extractUsername(String token) {
    return getClaims(token).getSubject();
  }

  public boolean isTokenExpired(String token) {
    return getClaims(token).getExpiration().before(new Date());
  }

  private Claims getClaims(String token) {
    return Jwts
      .parser()
      .setSigningKey(globalConfig.getJwt_secret())
      .parseClaimsJws(token)
      .getBody();
  }
}

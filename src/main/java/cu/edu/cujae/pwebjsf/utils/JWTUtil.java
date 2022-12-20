package cu.edu.cujae.pwebjsf.utils;

import cu.edu.cujae.pwebjsf.config.GlobalConfig;
import cu.edu.cujae.pwebjsf.services.UserServices;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

  @Autowired
  private GlobalConfig globalConfig;

  @Autowired
  private UserServices userServices;

  public String generateToken(UserDetails userDetails) {
    return Jwts
      .builder()
      .setSubject(userDetails.getUsername())
      .claim("roles", userDetails.getAuthorities())
      .claim(
        "userCode",
        Integer.toString(
          userServices.getUserByUsername(userDetails.getUsername()).getCode()
        )
      )
      .setIssuedAt(new Date())
      .setExpiration(
        /* 15 minutes */
        new Date(System.currentTimeMillis() + 1000 * 60 * 15)
      )
      .signWith(SignatureAlgorithm.HS256, globalConfig.getJwt_secret())
      .compact();
  }

  public String generateRefreshToken(UserDetails userDetails) {
    return Jwts
      .builder()
      .setSubject(userDetails.getUsername())
      .claim("roles", userDetails.getAuthorities())
      .setIssuedAt(new Date())
      .setExpiration(
        /* 1 hour  */
        new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1)
      )
      .signWith(SignatureAlgorithm.HS256, globalConfig.getJwt_secret())
      .compact();
  }

  public String generateTokenFromRefreshToken(String refreshToken) {
    return Jwts
      .builder()
      .setSubject(extractUsername(refreshToken))
      .claim("roles", extractRoles(refreshToken))
      .setIssuedAt(new Date())
      .setExpiration(
        /* 15 minutes */
        new Date(System.currentTimeMillis() + 1000 * 60 * 15)
      )
      .signWith(SignatureAlgorithm.HS256, globalConfig.getJwt_secret())
      .compact();
  }

  public String generateRefreshTokenFromRefreshToken(String refreshToken) {
    return Jwts
      .builder()
      .setSubject(extractUsername(refreshToken))
      .claim("roles", extractRoles(refreshToken))
      .setIssuedAt(new Date())
      .setExpiration(
        /* 1 hour  */
        new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1)
      )
      .signWith(SignatureAlgorithm.HS256, globalConfig.getJwt_secret())
      .compact();
  }



  public boolean validateToken(String token, UserDetails userDetails) {
    return (
      extractUsername(token).equals(userDetails.getUsername()) &&
      !isTokenExpired(token)
    );
  }

  public String extractUsername(String token) {
    return getClaims(token).getSubject();
  }

  public ArrayList<String> extractRoles(String token) {
    ArrayList<String> roles_String = new ArrayList<>();
    ArrayList roles = (ArrayList) getClaims(token).get("roles");
    for (Object role : roles) {
      roles_String.add(role.toString());
    }
    return roles_String;
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

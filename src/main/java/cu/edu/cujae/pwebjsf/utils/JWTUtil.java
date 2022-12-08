package cu.edu.cujae.pwebjsf.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

  private static final String KEY = "secretKEY";

  public String generateToken(UserDetails userDetails) {
    return Jwts
      .builder()
      .setSubject(userDetails.getUsername())
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
      .signWith(SignatureAlgorithm.HS256, KEY)
      .compact();
  }
}

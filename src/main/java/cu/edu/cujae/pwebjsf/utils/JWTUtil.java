package cu.edu.cujae.pwebjsf.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

  private static final String KEY =
    "cububcur3bvs5f25536hh342h7hd7t663gdtg3gbn3ik98vkubiubviudbiiutiuninis9gh8t48ib1b4r97874g43ngg98y9vy39h29h98yr2rh8y9124rh";

  public String generateToken(UserDetails userDetails) {
    return Jwts
      .builder()
      .setSubject(userDetails.getUsername())
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
      .signWith(SignatureAlgorithm.HS256, KEY)
      .compact();
  }

  public boolean validateToken(String token, UserDetails userDetails) {
    return userDetails.getUsername().equals(extractUsername(token)) &&
      !isTokenExpired(token);
  }

  public String extractUsername(String token) {
    return getClaims(token).getSubject();
  }

  public boolean isTokenExpired(String token){
    return getClaims(token).getExpiration().before(new Date());
  }

  private Claims getClaims(String token) {
    return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
  }
}

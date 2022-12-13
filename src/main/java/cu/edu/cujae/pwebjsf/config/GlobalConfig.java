package cu.edu.cujae.pwebjsf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalConfig {

  @Value("${spring.mail.username}")
  private String email_username;

  @Value("${spring.mail.password}")
  private String email_password;

  @Value("${spring.mail.host}")
  private String email_host;

  @Value("${spring.mail.port}")
  private String email_port;

  @Value("${spring.mail.properties.mail.smtp.auth}")
  private String email_auth;

  @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
  private String email_starttls;

  @Value("${jwt.secret}")
  private String jwt_secret;

  public String getEmail_username() {
    return this.email_username;
  }

  public void setEmail_username(String email_username) {
    this.email_username = email_username;
  }

  public String getEmail_password() {
    return this.email_password;
  }

  public void setEmail_password(String email_password) {
    this.email_password = email_password;
  }

  public String getEmail_host() {
    return this.email_host;
  }

  public void setEmail_host(String email_host) {
    this.email_host = email_host;
  }

  public String getEmail_port() {
    return this.email_port;
  }

  public void setEmail_port(String email_port) {
    this.email_port = email_port;
  }

  

  public String getEmail_auth() {
    return this.email_auth;
  }

  public void setEmail_auth(String email_auth) {
    this.email_auth = email_auth;
  }

  public String getEmail_starttls() {
    return this.email_starttls;
  }

  public void setEmail_starttls(String email_starttls) {
    this.email_starttls = email_starttls;
  }

  public String getJwt_secret() {
    return jwt_secret;
  }

  public void setJwt_secret(String jwt_secret) {
    this.jwt_secret = jwt_secret;
  }
}
